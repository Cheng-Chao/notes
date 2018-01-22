#### awk
|command|use|
|----|----|
|last -10 \| awk '$1=="root" {print $2}'|读入有'\n'换行符分割的一条记录，然后将记录按指定的域分隔符划分域，填充域，$0则表示所有域,$1表示第一个域,$n表示第n个域。默认域分隔符是"空白键" 或 "[tab]键",所以$1表示登录用户，$3表示登录用户ip,以此类推。|

#### string

all var is string in default 

|command|use|
|----|----|
|i=1;  ||
|${i}+=2; |  # ${i}=12 |
|j=3;  ||
|k=${i}${j}| # k=123  |
|m=${k}".tar"${i} |#m=123.tar12|






#### 命令的替换
$(pwd)  
()用来表示命令结果替换改变量  
locate .log|grep $(pwd)

vim $(locate .cpp|grep $(pwd))


#### 数组  

        SHA1000132656:~ # zhaojinzhou=(1 2 3 4 5 6 7)
        SHA1000132656:~ # echo ${zhaojinzhou[3]}
        4
        SHA1000132656:~ # echo ${zhaojinzhou[@]}
        1 2 3 4 5 6 7  
        
变量数组；尤其注意@符号的使用。  

---

#### 传参数  

        #!/bin/bash
        #author:菜鸟教程
        #url:www.runoob.com

        echo "Shell 传递参数实例！";
        echo "执行的文件名：$0";
        echo "第一个参数为：$1";
        echo "第二个参数为：$2";
        echo "第三个参数为：$3";
        为脚本设置可执行权限，并执行脚本，输出结果如下所示：
        $ chmod +x test.sh 
        $ ./test.sh 1 2 3
        Shell 传递参数实例！
        执行的文件名：./test.sh
        第一个参数为：1
        第二个参数为：2
        第三个参数为：3

        echo "-- \$* 演示 ---"
        for i in "$*"; do
            echo $i
        done

其中：   

        $#	传递到脚本的参数个数
        $*	以一个单字符串显示所有向脚本传递的参数。
        如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数。
        $$	脚本运行的当前进程ID号
        $!	后台运行的最后一个进程的ID号
        $@	与$*相同，但是使用时加引号，并在引号中返回每个参数。
        如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。
        $-	显示Shell使用的当前选项，与set命令功能相同。
        $?	显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误。



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
读取存储到zhao； 打印出来； 如果123.txt存在； 则打印exist； 否则打印not exist;

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
