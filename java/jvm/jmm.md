## happen before 原则

* 如果线程1解锁了monitor a，接着线程2锁定了a，那么，**线程1解锁a之前的写操作**都对线程2可见（线程1和线程2可以是同一个线程）。
* 如果线程1写入了volatile变量v（这里和后续的“变量”都指的是对象的字段、类字段和数组元素），接着线程2读取了v，那么，**线程1写入v及之前的写操作**都对线程2可见（线程1和线程2可以是同一个线程）。
* 传递原则 a hp b, b hp c, then a hp c;
* 单线程有序原则
* 线程开始原则
* 线程中断原则
* 线程终止原则
* 对象终止原则

example: 

|thread 1st|thread 2nd|
|---|---|
|int i=2; lock()|unlock(); Sysout i;|

如果unlock成功了，则i =2必然在lock()之前执行了。


## JVM堆内存布局

![](http://static.open-open.com/lib/uploadImg/20140128/20140128214841_435.jpg)


1	堆内存 = 年轻代 + 年老代 + 永久代

2	年轻代 = Eden区 + 两个Survivor区（From和To）

## 列含义

jstat -gc pid  sampling(采样时间ms) times(次数)

1	S0C、S1C、S0U、S1U：Survivor 0/1区容量（Capacity）和使用量（Used） 

2	EC、EU：Eden区容量和使用量

3	OC、OU：年老代容量和使用量

4	PC、PU：永久代容量和使用量

5	YGC、YGT：年轻代GC次数和GC耗时

6	FGC、FGCT：Full GC次数和Full GC耗时

7	GCT：GC总耗时
如果线程1解锁了monitor a，接着线程2锁定了a，那么，线程1解锁a之前的写操作都对线程2可见（线程1和线程2可以是同一个线程）。
如果线程1写入了volatile变量v（这里和后续的“变量”都指的是对象的字段、类字段和数组元素），接着线程2读取了v，那么，线程1写入v及之前的写操作都对线程2可见（线程1和线程2可以是同一个线程）。
