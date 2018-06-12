## persistence

#### AOF

**save the log of operation**  

* file bigger than rdb for same dataset
* appendfsync always（每次读写都持久化） 会造成性能上的影响


#### RDB

**将内存数据dump出去，redisdb**

* 定时dump，无法保证所有数据都持久化了。  
* 需要fork进程，如果数据量大会导致server性能问题。 


#### redis是AP   availability, partition 
#### zooleeper 是 CP consistency partition

#### [redis基本数据类型](http://naotu.baidu.com/file/5ab8bd4980ae00c27ce06638bbe7e883?token=a4bcaa015041c9fb)  

#### [redis VS mysql](https://repository.genmymodel.com/zhaojinzhou/redis-vs-mysql-uml)


