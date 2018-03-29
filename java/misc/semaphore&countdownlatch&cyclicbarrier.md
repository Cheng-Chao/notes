但是countlatch不能release()[+1]；只能countdown()[-1]和await()(等待).所以countdownlatch初始化的时候得是正数。

Semaphore与CountDownLatch相似，不同的地方在于Semaphore的值被获取到后是可以释放的，并不像CountDownLatch那样一直减到底。它也被更多地用来限制流量，类似阀门的 功能。如果限定某些资源最多有N个线程可以访问，那么超过N个主不允许再有线程来访问，同时当现有线程结束后，就会释放，然后允许新的线程进来。有点类似于锁的lock与 unlock过程。相对来说他也有两个主要的方法：

用于获取权限的acquire(),其底层实现与CountDownLatch.countdown()类似;

用于释放权限的release()，其底层实现与acquire()是一个互逆的过程。




AQS AbstractQueuedSynchronizer  
本质上就是一个链表，可以无限大。
提供了Acquire()和release()
semaphore和countdownlatch是他的wrapper。
