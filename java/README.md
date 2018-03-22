
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
* Permutation : Nqueen


## algorithm
---
* KMP
* Dijkstra
* DP
* Greedy 



## multiThread
---

* producer and consumer
    * lock and condition
    * semaphore
    * blockingqueue

* ThreadPool
    * ThreadPoolExecutor
    * Executors
    * BlockingQueue
    * [TheadFactory](./ThreadFactory.MD)


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
* [visitor](./visitor.md)

