* 线程安全的hashmap   :1. hashtable; 2.cocurrenthashmap(最好用分段锁bucket); 3.Collections.synchronizedMap(new map()); 

* **而ConcurrentHashMap中则是 一次锁住一个桶**。ConcurrentHashMap默认将hash表分为16个桶，诸如get,put,remove等常用操作只锁当前需要用到的桶。 

* Hashmap之前使用链表解决冲突。 尾部遍历--hash在rehash的时候正常会逆序。即lifo.  Race Condition  **多线程会造成环形连接导致infinite loop**

* Java 8中 hashmap 使用平衡树来替代链表存储冲突的元素。性能从O(n)提高到O(logn)




#### 任何变量和字符串相连接返回值都是字符串


#### basic concepts
* boxing and unboxing
  - boxing : put a basic type into a class
  - unboxing : translate a class into a basic type
#### classloader

* AppClassLoader->ExtClassLoader->BootStrapClassLoader

#### 加载流程
* 加载
* 链接
  - 验证
  - 准备
  - 解析
* 初始化


#### 装包和解包

* 将基本类型装包为类，将类解包为基本类型。 目前jvm已实现自动装解包
* integerCache类中会有-128-127的integer类**缓存**。
* ==号针对基本类型比较值，针对类比较引用。

      Integer a= 100
      Integer b =100
      a==b 
      true

      Integer a=new Integer(100)
      Integer b=new Integer(100)
      a==b
      false

