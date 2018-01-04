###实验证明，vector使用assign而不用重新构造函数的效率要高。assign()是摧毁原有任何数据，直接成立新vector，size也变，但内存不变，除非新vector内存要求比老的大。


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
