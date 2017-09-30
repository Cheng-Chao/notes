#### c++ 调用 c代码
 
     #ifdef __cplusplus
     extern "C" {
     #endif /* __cplusplus */
     VOS_UINT32 CeimGetUecpmMsgType(VOS_MSG_BLOCK *msg);
     #ifdef __cplusplus
     }
     #endif /* __cplusplus */

---

#### RPC remote procedure call  
远程调用：分为同步调用（等回复）和异步调用（不等回复）  
框架：Rest API

#### 函数对象  
如果您编写的lambda表达式很长，应考虑转而使用函数对象，即实现了operator()的类.  
`自定义排序谓词`另一个作用map第3个参数默认less,可以定义一个函数对象传入

---

#### linux 命令格式：command &  
当在前台运行某个作业时，终端被该作业占据；而在后台运行作业时，它不会占据终端。可以使用&命令把作业放到后台执行。

---

#### git知识：
* git 别名的用法：alias push="git push" (提高效率 & 装逼带你飞专用)
* git reflog 找到**之前的操作log**  主要用于误删除节点，git reset并不会立即就删除节点。

-------  

#### 分布式操作系统和数据库相关的知识：  
1. ACID atomicity consistency（系统中不存在失败的事务） isolation durability    
2. 4 levels of isolation :  

     ![](http://images2015.cnblogs.com/blog/903715/201611/903715-20161102150430955-492049629.png)  

   * read uncommitted（脏读）;  
   * read committed（不可重复读【主要原因是事务希望可重复读{前后读取的数据一致}】）;   
   * repeatable read（幻读【增删】，）;   
   * serialization（最高级别）。  

3. cap理论 分布式操作系统的3大特性：**一致性，可用性，和分区容错性不可能同时满足**。    

    一致性：其中一个节点的数据正确的修改后其他节点的数据也应该相应的正确修改。  

    可用性：**有限时间内**总能**返回正常响应结果**；  

    分区容错性：  发生分区故障时；依然提供一致性和可用性服务；  

----  

#### 一致性协议  

2PC (phase commit):  
2种角色：协调者coordinator（1个）; 参与者（很多）

    1 提交事务请求  
      1.1 事务询问（协调者->参与者）  
      1.2 执行事务（参与者）  
      1.3 参与者向协调者反馈事务询问响应（参与者->协调者）  

    2 执行事务提交
      2.1 发送提交请求 （协调者->参与者）    
      2.2 事务提交  (参与者)  
      2.3 反馈事务提交结果 (参与者->协调者)   
      2.4 完成事务  (协调者)  
pros & cons:  
简单易实现；  
**同步阻塞**（必须要等所有参与者完成）；**单点问题**（如果协调者出现问题\~呵呵）；**数据不一致**（如果协调者在phase 2中的回复消息丢失~造成有的数据库更新了，其他的没有）；**太过保守**。  

3PC (phase commit)  

paxos  


#### c++11相关知识点  
void excpt_func() `noexcept`;  
另外一种则可以接受一个常量表达式作为参数，如下所示：  
void excpt_func() `noexcept (常量表达式);`  

---

<ratio> 头文件
定义了分数类，和与分数相关的操作。  
**头文件中的内容全部都是类**  

          Classes
          ratio
          Ratio (class template )

          ratio arithmetic:
          ratio_add
          Add two ratios (class template )
          ratio_subtract
          Subtract ratios (class template )
          ratio_multiply
          Multiply two ratios (class template )
          ratio_divide
          Divide ratios (class template )

          ratio comparison:
          ratio_equal
          Compare ratios (class template )
          ratio_not_equal
          Compare ratios for inequality (class template )
          ratio_less
          Compare ratios for less-than inequality (class template )
          ratio_less_equal
          Compare ratios for equality or less-than inequality (class template )
          ratio_greater
          Compare ratios for greater than inequality (class template )
          ratio_greater_equal
          Compare ratios for equality or greater-than inequality (class template )


#### 多线程相关知识  
* c++ <thread>头文件  
std::this_thread命名空间,包含4个方法：  
     get_id()  
     yield()  
     sleep_until()  
     sleep for()  
 
 ---
 
 #### miscellaneous  
 
 * 3次握手，为了**防止已失效的连接请求报文段突然又传送到了服务端**，因而产生错误；  
 client ->(sync) target_client 为了区分用户id还发了一个随机数  
 target_client ->(sync+ack) client 随机数加1  
 client ->(ack) target_client  
 
 

* 4次握手，主要是因为TCP为**全双工，FIN（finish）只是表明发送发停止发送消息了**。  
client ->(FIN) target_client  
target_client ->(ACK) client  
target_client ->(FIN) client  
client ->(ACK) target_client  

#### hadoop  
hbase 是google bigtable的开源实现。
chubby 对应zookeeper协调一致

