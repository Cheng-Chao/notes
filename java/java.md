
因为静态内部类是外部类的静态成员，静态成员是不需要外部类对象而存在的，所以在外部类外，对静态内部类进行访问时是不需要创建外部类对象的。

Static 修饰符
静态成员变量，静态方法，静态代码块，静态内部类。


内部类
Wai w=new Wai(); 
Wai.Nei wn=w.new Nei(); 
[Wai.Nei wn=new Wai().new Nei();]



所有的异常类继承Throwable类，
两个直接子类，Error类和Exception类。
其中runtime exception 和 error类是非捕获异常（不必须处理异常）
其他为必须处理异常。
throws语句是在方法的声明中使用来抛出异常，而throw语句是在方法体内使用抛出异常。


在Exception类中又有一个RuntimeException类。在Exception类中的直接和间接子类中除去RuntimeException类的直接和间接子类，都是捕获异常。其他的都为未捕获异常。
printStackTrace();
toString();
getMessage();



接口里的变量默认是static final 必须赋值。


java中Object类中包括toString()方法。
直接打印类，其实是调用toString();


重写equals方法的时候请重写hashcode();主要是在hashtable类似的集合中会遇到冲突。
（1）同一个对象多次hashCode()值相同；
（2）equals()返回true时，hashCode()返回相等的（int）值；
（3）equals()方法比较的Filed(成员变量（类属性）)，都应该用来计算hashCode值。
比较常见的重写方法是：
将计算出的每个Filed的hashCode值相加返回，为了避免直接相加产生的偶然相等（单个不相等，加起来就相等了），为每个Filed乘以一个质数后再相加，


Math.random()返回的是0-1之间的double


final修饰方法时。被方法能被子类所继承，但不能重写了。

默认类的访问级别。只能被同包下的类访问。
默认成员变量,在一个同包里的类或子类是能够访问的，相当于public类型，但是在不同包里的类或子类没有继承该成员变量，是访问不到它的。



静态引入就是引入包中的静态成员变量和静态方法。
import static 包名.aaa.*; 
import static 包名.aaa.方法名称;
import static java.lang.System.out;

euqals区别 == 

复合数据类型在没有覆写equals()，比较还是地址，因为Object的equals方法也是用双等号（==）进行比较的。
包装类不同，类内部已经重写了equals（）；


重写equals（）方法后记得重写hashcode（）方法.
原因：
The problem is with collections where unicity of elements is calculated according to both .equals() and .hashCode(), for instance keys in a HashMap.









String 字符串常量
StringBuffer 字符串变量（线程安全）
StringBuilder 字符串变量（非线程安全）


Java对象的内存布局：对象头（Header）,实例数据（Instance Data）和对齐填充（Padding）
其中对象头包括
Java对象头在非数组类型下是2个字宽，如果是数组类型则是3个字宽
 1.markword
2.类型指针klass
3.如果是数组的话包括数组长度






#### 锁的状态总共有四种：无锁状态、偏向锁、轻量级锁和重量级锁。
![makword锁](http://img.blog.csdn.net/20151217151455512?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

轻量级锁是为了在线程交替执行同步块时提高性能，而偏向锁则是在只有一个线程执行同步块时进一步提高性能。


#### 类加载

当运行一个程序的时候，JVM启动，运行bootstrapclassloader，该ClassLoader加载java核心API（ExtClassLoader和AppClassLoader也在此时被加载），然后调用ExtClassLoader加载扩展API，最后AppClassLoader加载CLASSPATH目录下定义的Class，这就是一个程序最基本的加载流程。

#### 自旋锁spinlock

忙等待（本线程不停获取锁）和让权等待（遇等待直接让出）

自旋等待不能代替阻塞。自旋等待本身虽然避免了线程切换的开销，但它是要占用处理器时间的，因此，如果锁被占用的时间很短，自旋当代的效果就会非常好，反之，如果锁被占用的时间很长，那么自旋的线程只会拜拜浪费处理器资源。因此，自旋等待的时间必须要有一定的限度，如果自旋超过了限定次数（默认是10次，可以使用-XX:PreBlockSpin来更改）没有成功获得锁，就应当使用传统的方式去挂起线程了。

 #### 十大Intellij IDEA快捷键
 
 * ctrl alt l  格式化
 * ctrl \/行注释 （解注释）
 * ctrl shift \/ 段注释 （解注释）
 
 
 1. 一个java文件中，可用有多个类，但public修饰的类只能有一个，并且与文件名同名。
 2. vector 和 arraylist的区别   vector是线程安全的，而arraylist不是。并且内存分配机制不同，其中vector是double，arraylist是half
