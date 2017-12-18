

docker 是容器引擎：  


| command | use |
|-------|--------|
|docker ps| 显示正在运行的容器|
|docker ps -a -q | 显示所有容器 的id(删除的时候h)|
|docker commit -m "message" -a "author"|目前创建的容器id 保存的镜像名 |
|docker run -i(interative) -t|(返回伪tty) -d(后台)  镜像名称 bin/bash|
|docker run -it  ubuntu:lastest /bin/bash| |
|docker build -t runoob/centos:6.7 .| 镜像名称|
        
       
基本命令：  


       docker cp src/file dockername(or docker_id):home/path  

       docker exec -it(interative tty) ubuntu  bin/bash  

       docker tag long_long_name_image short_name 标tag  

       docker inspect id 详细检查container 配置。  
       docker rm container_id;
       docker rmi image_id;
