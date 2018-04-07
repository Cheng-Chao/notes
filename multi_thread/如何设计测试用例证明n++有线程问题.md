如何设计测试用例证明n++有线程问题

for循环很大次    开俩个线程；不停调用n++函数。

      main(){
        Thread t1 = new Thread(new runnable(){
          n++;
        }).start();

        Thread t2 = new Thread(new runnable(){
          n++
        }).start();
        
        t1.join();
        t2.join();
        
        if(expected!=n) syserr("wrong");
      }

预测调用后值应该为n+2，**如果不等则代码有问题**。



