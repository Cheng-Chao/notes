## Item 24th declare non-member function when all paras need type conversions

1. 针对一个需要实现rational类。满足交换律和int乘法。
2. 如果实现为成员函数的话：  

        const rational rational::operator*(const rational &right){return this.data * right.data;}  

    2.1 操作符左边值为int导致无法交换, (右边值为int会调用隐式转换)；而这里期望左值也隐式转换  

3. 如果实现为non-member函数  

        const rational operator *(const rational &left, const rational &right){return left.data * right.data;}
    
    3.1 尽可能不要用friend函数，除非没提供私有成员变量的get();

### 这个条款存在需要注意的是：一般情况下类的隐式转换不被允许，explicit constructor()；另可申明重写一个参数为int的函数，不要调用隐式转换。这里针对如果你想用隐式转换，需要转换的类型为操作符左边的值，需要将operator定义为nonmenber. 

----


## Item 25th  
