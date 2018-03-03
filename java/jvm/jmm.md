

## JVM堆内存布局

![](http://static.open-open.com/lib/uploadImg/20140128/20140128214841_435.jpg)


1	堆内存 = 年轻代 + 年老代 + 永久代

2	年轻代 = Eden区 + 两个Survivor区（From和To）

## 列含义
1	S0C、S1C、S0U、S1U：Survivor 0/1区容量（Capacity）和使用量（Used） 

2	EC、EU：Eden区容量和使用量

3	OC、OU：年老代容量和使用量

4	PC、PU：永久代容量和使用量

5	YGC、YGT：年轻代GC次数和GC耗时

6	FGC、FGCT：Full GC次数和Full GC耗时

7	GCT：GC总耗时
