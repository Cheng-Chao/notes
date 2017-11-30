* 上一条命令的执行结果 `$?`  0表示成功；1表示失败
* bash中true表示执行成功实际值为0； false表示执行失败实际值为1。
* 检测文件属性 `test EXPRESSION //example: test -f 123.txt` 判断是否是文件

![test表达式](http://images.cnitblog.com/blog/497634/201305/29211817-06f95939c02a4fd2988c4b35dd468417.jpg)

* []条件判断左右必须有空格
* 条件语句：   

      if 条件1
      then 命令1
      elif 条件2
      then 命令2
      else 命令3
      fi

* 
