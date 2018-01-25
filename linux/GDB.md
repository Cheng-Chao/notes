
---
#### GDB 命令精简版：
1. 查看结构体大小  直接p sizeof(class_name)

2. 将输出的相关信息存到file中譬如码流，调用栈

(gdb) set logging file <file name>

(gdb) set logging on

(gdb) info functions

(gdb) set logging off


---
##### 开始

* `g++ -g quicksort.cpp -o quicksort.out`  

    * 注意`-g`选项，代表的是编译的时候将源码中的行数相关信息一起编译进目标代码。

* `gdb quicksort.out`  

    * 进入main函数进行调试了。  

* `r`  

    * 开始调试  

* `set stop-on-solib-events 0`
    * 遇到共享库的时候不暂停

* `q`  

    * 退出GDB  

* set var width=47
    * 修改变量值

* shell ls  运行shell命令

* cat /proc/sys/kernel/core_pattern     core-dump的路径设置
---

##### 调用栈

* `bt(backtrace) 10 `  别名包括\(`info stack`  `where` \)

    * 就是callstack，打印最上面10个  
    * `info help` 非常有用  

---
##### 打断点

*可以用tab找函数名超方便*

|语法|用途 |
| ---- | ---------------- |
|`b (break) quicksort.cpp:100`   |在quicksort.cpp 100行打断点  |
|`b InitContextPreCheckProc::_StartWork`|在InitContextPreCheckProc::\_StartWork 函数开始打断点   |
|`info b`|显示所有的断点|
|`d(delete)` 2-4|删除id为2-4的断点(info b中的num)|
|`clear 21`|删除21行的断点|
|`disable 2-4`|disable id为2-4的断点|

---
##### 显示代码

|语法|用途 |
| ---- | ---------------- |
|`l` |显示当前断点出代码  |
|`l func_name`|显示函数代码|
|`l 100,120`|显示第100-120行的函数代码|
|`layout`|TUI展示代码|

----
##### 控制执行

|语法|用途 |
| ---- | ---------------- |
|`c(continue) ` |运行到下一断点出（vs F5）|
|`n(next) [10]`|单步，执行10行，不进入调用函数(vs F10)|
|`s(step) [10]`|单步,执行10行, 进入调用函数（vs F11）|
|`f(finish)`|退出当前函数（vs shift F11）|
|`return [expr] (* 很强大 *，不能简写，r含义很多)`|退出当前函数,剩下的函数都不执行，打桩返回值\[expr\]（vs shift F11）|

---

##### 查看变量值

|语法|用途 |
| ---- | ---------------- |
|`p(print) var_name ` |打印变量值|
|`display var_name ` |每次都自动打印变量值|
|`info local` |打印所有临时变量值|


##### 查看内存数据
|语法|用途 |
| ---- | ---------------- |
|`x /100x <addr> ` |用gdb查看内存|
|`x ` |examine|
|`100` |表示要显示的内存单元的个数|
|`x` |十六进制|
|`d` |十进制|




##### 其他不常用

|语法|用途 |
| ---- | ---------------- |
|clear |删除所有断点  |
|clear function |删除函数断点 |
|clear filename:function |删除文件：函数断点|
|clear linenum|删除行断点|
|clear filename:linenum |删除文件行断点|
|`l +10`|往下移动10行 往上移动10行 |
|`l -10` |往上移动10行 |
|`break +10` |往后移10行|
|`break -10` |往前移10行 |


|查看内存数据语法|
| ---- |
|x 按十六进制格式显示变量。
d 按十进制格式显示变量。
u 按十进制格式显示无符号整型。
o 按八进制格式显示变量。
t 按二进制格式显示变量。
a 按十六进制格式显示变量。
i 指令地址格式
c 按字符格式显示变量。
f 按浮点数格式显示变量。
u表示一个地址单元的长度
b表示单字节，
h表示双字节，
w表示四字节，
g表示八字节|


