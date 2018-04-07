
## problems
---

* lgk :  topk
    * if()
* dp : longest common subsequence in two string
    * dp[i][j] = (dp[i][j]+1) if(str1[i] = str2[j])
	* = max(dp[i][j-1], dp[i+1][j]) else if(str1[i] != str2[j])
* dp : how to get longest palindrome (and a better solution)
    * dp[i][j] = dp[i+1][j-1]+2 if(str[i] = str[j])
    * = max(dp[i][j-1], dp[i+1][j]) else if(str[i] != str[j])
    * 
* dp : longest ascending subsequence
* dp : 最大子数组和


* Permutation : Nqueen


## algorithm
---
* KMP
* Dijkstra
* DP
* Greedy 

## multiThread
---

* [Thread](./multi_thread/Thread.md)
    * [Timer](./multi_thread/Timer.md)

* producer and consumer
    * lock and condition
    * AQS
        * Semaphore
        * CountdownLatch
        * CyclicBarrier
    * blockingqueue
        * [ArrayBlockingQueue](./multi_thread/BlockingQueue.md)
        * [LinkedBlockingQueue](./multi_thread/BlockingQueue.md)
        * DelayQueue
        * PriorityBlockingQueue
        * SynchronousQueue

* ThreadPool
    * ExecutorService
        * ThreadPoolExecutor
        * ScheduledExecutorService
            * ScheduledThreadPoolExecutor

    * Executors
        * newCachedThreadPool().execute(Runnable)       // can cache INT_MAX threads in thread pool but **none in core pool**
        * newFixedThreadPool(int).execute(Runnable)     // all in core pool
        * newScheduledThreadPool(int).schedule(Runnable,int,TimeUnit) 
        * newSingleThreadExecutor().execute()
        * newSingleScheduledThreadExecutor().schedule()
    * BlockingQueue
    * [TheadFactory](./multi_thread/ThreadFactory.md)


## sort
---


* mergesort
* quicksort
* heapsort
* bubblesort
* shellsort
* radixsort

## Design Pattern
---

* singleoton
* observer
* flyweight
* factory
* [visitor](./design_pattern/visitor.md)

