## Item 24th declare non-member function when all paras need type conversions

1. 针对一个需要实现rational类。满足交换律和int乘法。
2. 如果实现为成员函数的话：  

        const rational::operator*(const rational &right){return this.data * right.data;}  

    2.1 左值为int导致无法交换  

3. 如果实现为non-member函数  

        const rational operator *(const rational &left, const rational &right){return left.data * right.data;}
    
    3.1 尽可能不要用friend函数，除非没提供私有成员变量的get();
