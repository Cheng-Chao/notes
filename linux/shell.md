$* 与 $@ 区别：
相同点：都是引用所有参数。
不同点：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）。
 
        #!/bin/bash
        # author:菜鸟教程
        # url:www.runoob.com

        echo "-- \$* 演示 ---"
        for i in "$*"; do
          echo $i
        done

        echo "-- \$@ 演示 ---"
        for i in "$@"; do
          echo $i
        done
        执行脚本，输出结果如下所示：
        $ chmod +x test.sh 
        $ ./test.sh 1 2 3
        -- $* 演示 ---
        1 2 3
        -- $@ 演示 ---
        1
        2
        3
