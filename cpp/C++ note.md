### 如何构造一个不能被继承的类：

1. 构造函数必然是private；导致子类无法实例化。  
1.1 本类的实例化通过一个public静态函数接口static createSelf()调用构造函数,返回指针实现。  
1.2 导致的俩个问题：  
  1.2.1 'self* = self::createSelf()' 调用者可能会忘记删除  
  1.2.2 无法栈上实例化  
1.3 解决方法：  
  1.3.1 利用友缘类可以访问私有成员但是没办法被继承实现。


              class Usable;
              class Usable_lock {
                friend class Usable;
              private:
                Usable_lock() {}
                Usable_lock(const Usable_lock&) {}
              };

              class Usable : public virtual Usable_lock {
                // ...
              public:
                Usable();
                Usable(char*);
                // ...
              };

              Usable a;

              class DD : public Usable { };

              DD dd;  // error: DD::DD() cannot access
                    // Usable_lock::Usable_lock(): private  member


Usable继承了 Usable_lock；因为是友缘所以可以访问私有成员-构造函数。  
但是DD继承了Usable不是友缘所有无法调用父类Usable_lock构造函数。


----

### 实验证明，vector使用assign而不用重新构造函数的效率要高。assign()是摧毁原有任何数据，直接成立新vector，size也变，但内存不变，除非新vector内存要求比老的大。


# c++ notes

### trivial
* 如果**改写类的operator=** 一定要**判断**入参是不是自己，如果是直接返回\*this.
* set和map的成员函数insert返回值为pair<iterator,book> 位置和结果。

### [PROC CATCH]()
---
### [Macro defined singleton](https://github.com/zhaojinzhou/notes/blob/master/singleton.cpp);  
---
### [Shared_ptr introduction](https://github.com/zhaojinzhou/notes/blob/master/shared_prt.md);  
ps:   
shared_ptr [example](http://www.cplusplus.com/reference/memory/shared_ptr/?kw=shared_ptr);  
weak_ptr [example](http://www.cplusplus.com/reference/memory/weak_ptr/weak_ptr/);

---
### [StdIO example](https://github.com/zhaojinzhou/notes/blob/master/stdio.md)
---
### [STLlib introduction](https://github.com/zhaojinzhou/notes/blob/master/STLlib.md)
---
### [C String split c++ string split](https://github.com/zhaojinzhou/notes/blob/master/c_string_split_%26_c%2B%2B_split.md)
---



### [memcache]()  

### [nedmalloc]()  

### [log4cpp]()  

### [socket]()  
