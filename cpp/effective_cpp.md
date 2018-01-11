## Item 1 view c++ as a federation languages

- c++ 有很多用法其中重点包括：
  + c语言风格
  + object-oriented c++
  + template c++
  + STL
 
---

## Item 2 prefer enum , consts, and inlines to #define 

- 尽可能不用宏定义

---

## Item 3 use const whenever possiable
- 尽可能使用const
    + 巧用mutabel关键字

---

## Item 4 initialize obj before they are used
    
- 建议初始化；尽管全局或者静态的基本类型，编译器会自动初始化，一般为0。
- 类中的基本类型成员变量，编译器不会初始化的。堆中cdcdcd,栈中cccc (vs为例)。因此**类的成员变量初始化**非常重要。(项目中遇到的类未初始化问题)
- 类中成员变量可以考虑在构造函数中赋值或者在**构造函数初始化列表中初始化（more efficient）**
  - 类中的成员变量的顺序是安声明顺序执行，跟初始化列表无关, 初始化列表效率更高。
  - **初始化列表直接调用成员函数复制构造函数初始化，而在构造函数中赋值，是 构造函数->赋值操作符。** 
    - 【已写代码验证，请重视：初始化列表进行成员初始化，不会先调用构造函数，而是直接调用复制构造函数。省事】【在构造函数中用赋值操作符赋值，是先调用构造函数再调用赋值操作符。】 


- non-local-static 对象（全局或类中或namespace中）尽量要用 local-static对象（函数内static对象）代替。优势：
  1. local-static如果用不到，不需要构造和析构代价.
  2. 如果non-local-static 对象之间有依赖关系，`static a ;class a{ static b;}` 你无法保证b在a之前被初始化。（**c++编译器无法保证non-local-static对象的初始化顺序。**）

---


## Item 17 store newd OBJ in smart pointer in standalone statements

- 当函数参数为智能指针时， 请不要直接在参数中转换指针为智能指针，会导致资源泄露。  
     * 如void print(shard_ptr\<int\> a, int a); 请不要使用 ~print(shard_ptr\<int\>(new int(10)), 9)）~
     * 应该用 int \*a = new int\(10\);  print(shard_ptr<int>(a),9);
- 原因是c++编译器在执行时1. print ; 2. new in() 3. shard_ptr<>() 3者的执行顺序不一定。 可能先2,1(异常)，3；导致资源泄露。
- 另外在项目中的经验是：先new(); new完以后立刻放入智能指针中，中间不允许出现任何代码。（资源和资源管理器之间如果出现任何可能的异常都会导致资源泄露）

---

## Item 18 make interface easy to use correctly and hard to use incorrectly

- 接口设计首先应该尽可能做到：编译通过即正确使用。
- 接口参数使用类型和顺序都应该是要考虑的内容。  
  + 例如void setDate(int month, int day, int year) 这样的接口会导致误用（顺序，类型和取值的误用）。
  + 解决方法: 1. 限制类型; 2. 限制取值范围。
    * 参数传类型而非int; void setDate(class month, class day, class year)（保证类型和顺序）;
    * 限制month 和day 的取值范围，将构造函数私有化，提供static getter获取1-12月实例。
---


## Item 20th pass　by reference to const rather than pass by value
1. 很明显，如果pass by value 需要调用构造函数和析构函数，代价比较大。reference则不需要，效率比较高

2. 内置的基本类型和stl中的迭代器， 函数对象pass by value可能效率更高。

3. 发生slicing：  
    3.1 如果pass by value 函数参数是父类，而传入子类一定会发生slicing  
    3.2 如果pass by reference 不会发生slicing，类似指针；
    
----

## Item 21th dont return a reference when you must return a object

1. return reference的风险：  
1.1 reference对象可能不存在(stack上分配)。  
1.2 reference对象在堆上分配，指针无法获取以删除。(`const rational& operatpr*(){return new rational; }   a*b*c `"这种情况必然会导致泄露")  
1.3 reference对象可能会被修改。  
1.4 如果返回了static变量则需要注意多线程。

2. 不要返回所定义的函数内创建的任何local对象(无论stack或者heap)  。

3. 要注意所返回的数据的敏感性。  

4. 不要返回static变量（除非想写成单例，需要double check NULL,锁）.

---
## Item 22th Declare data private
1. 应该将数据设为private, 提供 getter;
---

## Item 24th declare non-member function when all paras need type conversions

1. 针对一个需要实现rational类。满足交换律和int乘法。
2. 如果实现为成员函数的话：  

        const rational rational::operator*(const rational &right){return this.data * right.data;}  

    2.1 操作符左边值为int导致无法交换, (右边值为int会调用隐式转换)；而这里期望左值也隐式转换  

3. 如果实现为non-member函数  

        const rational operator *(const rational &left, const rational &right){return left.data * right.data;}
    
    3.1 尽可能不要用friend函数，除非没提供私有成员变量的get();

### 这个条款存在需要注意的是：一般情况下类的隐式转换不被允许，explicit constructor()；令可申明重写一个参数为int的函数，不要调用隐式转换。这里针对如果你想用隐式转换，需要转换的类型为操作符左边的值，需要将operator定义为nonmenber. 

----


## Item 25th  
## Item 32th 李氏替换原则

1. 适用于父类的地方，子类一定合适。或者可以说，父类所拥有的特性，子类都应该拥有。或者可以说正确处理is-a的关系。


-----

## Item 36th do not change a non virtual member function inherited from father class

1. 这里主要注意如果是 non virtual 则不会进行多态，如果用一个父类指针和一个子类指针指向同一个子类对象，调用的函数不是相同的而函数，而是父指针调用父类函数，子指针调用子类函数（虽然是同一实例，这里的话容易出错）。

-------
