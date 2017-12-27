

docker 是容器引擎：  

----
#### mount
|command|use|
|----|----|
|docker run -v /home/host_path:/container_path/|mount host_path to container_path|


----
#### basic

| command | use |
|-------|--------|
|docker ps| 显示正在运行的容器|
|docker ps -a -q | 显示所有容器 的id(删除的时候h)|
|docker commit -m "message" -a "author"|目前创建的容器id 保存的镜像名 |
|docker run -i(interative) -t|(返回伪tty) -d(后台)  镜像名称 bin/bash|
|docker run -it  ubuntu:lastest /bin/bash| |
|docker build -t runoob/centos:6.7 .| 镜像名称|


----
#### network

* bridge  default
* container
* host
* none

|command|use|
|----|----|
|docker network ls|显示所有网络|
|docker network connect network_id docker_id|  the docker joins into the network |
|docker network inspect bridge|检查目前docker中所有container的网络状况（IP等等）|

https://docs.docker.com/engine/userguide/networking/#the-default-bridge-networkdocker network inspect bridge

#### 文件互传

|command| use|
|----|----|
|docker cp /home/host dockerid:/home/| copy files in host to container |
|docker cp dockerid:/home /home|copy files in container to host|

        
       
基本命令：  


       docker cp src/file dockername(or docker_id):home/path  

       docker exec -it(interative tty) ubuntu  bin/bash  

       docker tag long_long_name_image short_name 标tag  

       docker inspect id 详细检查container 配置。  
       docker rm container_id;
       docker rmi image_id;
