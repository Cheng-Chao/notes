* 上一条命令的执行结果 `$?`  0表示成功；1表示失败
* 读取bash输入的参数  $1 $2  代表输入的参数。 `echo $1` 打印第一个参数。

* bash中true表示执行成功实际值为0； false表示执行失败实际值为1。
* 检测文件属性 `test EXPRESSION //example: test -f 123.txt` 判断是否是文件

![test表达式](http://images.cnitblog.com/blog/497634/201305/29211817-06f95939c02a4fd2988c4b35dd468417.jpg)

* []条件判断左右必须有空格
* 管道机制的字符串截取， `echo $PATH | cut -d ':' -f 5`
* 条件语句：    

      if 条件1
      then 命令1
      elif 条件2
      then 命令2
      else 命令3
      fi

* 实例1：

      read zhao
      echo $zhao
      if [ -f 123.txt ]
      then echo "exist"
      else echo "not exist"
      fi
      exit 0
* 实例2：
列出所有的进程; 只含有 sbin; 以“ ”为分隔符 取第12个; 双重定向输出到屏幕和赵金洲.txt

      ps -ef | grep sbin | cut -d ' ' -f 12 |tee zhaojinzhou.txt  
