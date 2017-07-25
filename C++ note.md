# c++ notes
### macro defined singleton;
\/\*------------------use macros to define a Singleton----------------\*\/  
`#define DECLEAR_GET_INSTANCE(class_name)  
        public:                             \\
        static class_name* GetInstance()    \\
        {                                  \\
          static class_name* instance = NULL;\\
          if(NULL == instance)             \\
          {                                \\
            instance = new class_name;      \\
          }                                \\
          return instance;                 \\
        }                                  \\ 
`

`#define DECLARE_SINGLETON(class_name)      \
        DECLEAR_GET_INSTANCE(class_name)   \
        protected:                         \
        class_name();                      \
        ~class_name();                     \
        class_name(const class_name& );    \
        const class_name& operator=(const class_name&);  
`      

### common func in stl;

//STL常见函数：
* Distance() ；	//inline typename iterator_traits<_InputIterator>::difference_type Distance(_InputIterator __first, _InputIterator __last)； return n; //俩参数为俩指针；返回俩个指针之间的距离。如：int 20; 
* unique()；	//ForwardIterator     unique(_ForwardIterator __first, _ForwardIterator __last)；return __last; //去重函数；记得是相邻俩元素去重！ 如果是数组记得排序。
//结合使用确定数组中不同数的个数：	
* 1.sort(a,a+sizeof(a)/sizeof(a[0]))2.distance (a,unique(a,a+sizeof(a)/sizeof(a[0]));  //distance 返回int值，unique返回最后一个不同元素的指针。

### func in string;
                                                                       
String 类函数总结：
earse();  
* 1.basic_string&       
* erase(size_type __pos = 0, size_type __n = npos) //删除pos开始的字符串，删除长度为npos(一般整形)；2.iterator
* erase(iterator __position) //删除position开始以后的字符串, __position 是string迭代器开始位置。返回删除点开始位置3.iterator
* erase(iterator __first, iterator __last)//删除string迭代器__first到__last之间的内容，返回删除点开始位置；
		
Replace()  
* 1.basic_string&
* replace(size_type __pos, size_type __n, const basic_string& __str)
}
