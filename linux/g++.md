----

#### 常用的参数(注意大小写)：

|commmand|use|
|--------|------|
|-E|只预处理，将宏替换|
|-S|只预编译和编译，生成汇编文件|
|-c|只预编译，编译和汇编，生成静态库|
|-o|表示生成目标可执行文件|

|Example|result|
|----|----|
|g++ -E quicksort.cpp [> quicksort_back.cpp]|展开头文件和宏定义，[定向到quicksort_back.cpp](默认命令行中输出)|
|g++ -S quicksort.cpp|生成quicksort.s,里面是汇编语言,可以用vim查看汇编源码|
|g++ -c quicksort.cpp|生成目标码，用于静态库quicksort.o(需要ar -crv生成静态库)|
|g++ quicksort.cpp -o quicksort.out -I ./|生成可执行文件quicksort.out，其中-I代表include头文件的寻找目录|

----

#### 举例编译一个含有静态库的代码


4个文件  

bill.cpp，fred.cpp，lib.h，main.cpp  

|commmand|use|
|--------|------|
|g++ -c bill.cpp fred.cpp|编译生成目标码|
|ar -crv lib.a bill.o fred.o|打包成静态库lib.a|
|g++ main.cpp lib.a -o main.out|打包生成可执行文件|

-----


mak
