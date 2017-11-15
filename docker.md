docker 是容器引擎：  

       docker ps 显示正在运行的容器；
       docker ps -a 显示所有容器；
       docker commit -m "message" -a "author" 目前创建的容器id 保存的镜像名 
       docker run -i(interative) -t(返回伪tty) -d(后台)  镜像名称 bin/bash
       docker run -it  ubuntu:lastest /bin/bash
       docker build -t 镜像名称
       docker build -t runoob/centos:6.7 .
基本命令：  


    docker cp src/file dockername(or docker_id):home/path  

    docker exec -it(interative tty) ubuntu  bin/bash  

