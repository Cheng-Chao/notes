


#### 锁的状态总共有四种：无锁状态、偏向锁、轻量级锁和重量级锁。
![makword锁](http://img.blog.csdn.net/20151217151455512?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)



#### 类加载

当运行一个程序的时候，JVM启动，运行bootstrapclassloader，该ClassLoader加载java核心API（ExtClassLoader和AppClassLoader也在此时被加载），然后调用ExtClassLoader加载扩展API，最后AppClassLoader加载CLASSPATH目录下定义的Class，这就是一个程序最基本的加载流程。

#### 自旋锁spinlock

忙等待（本线程不停获取锁）和让权等待（遇等待直接让出）


 #### 十大Intellij IDEA快捷键
 
 * ctrl alt l  格式化
 * ctrl \/行注释 （解注释）
 * ctrl shift \/ 段注释 （解注释）
 
 
 1. 一个java文件中，可用有多个类，但public修饰的类只能有一个，并且与文件名同名。
 2. vector 和 arraylist的区别   vector是线程安全的，而arraylist不是。并且内存分配机制不同，其中vector是double，arraylist是half
