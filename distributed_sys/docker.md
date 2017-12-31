#### export

|command|use|
|----|----|
|docker export -o target.tar container_id| `-o` name of the target tar|
|docker export container_id > target.tar|`>` redirect|

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
|docker ps -aq | 显示所有容器 的id(删除的时候h)|
|docker commit -m "message" -a "author"|目前创建的容器id 保存的镜像名 |
|docker create images_name| create a container using the images, but **dont run** it|
|docker start container_id|start the **stopped** container|
|docker exec -it ubuntu /bin/bash| execute the command in the **runing** container|
|docker run -i(interative) -t|(返回伪tty) -d(后台)  镜像名称 bin/bash|
|docker run -it  ubuntu:lastest /bin/bash| equals to `docker create` then `docker start` then `dokcer exec`|
|docker build -t runoob/centos:6.7 .| 镜像名称|
|docker rm \[-f\] docker_id| remove stopped\[running\] container|
|docker rmi image_name| remove images|
|dokcer stop \[rm\] $(docker ps -q)|stop\[remove\] all running containers |
|docker tag long_name_image short_name| tag the image|
|docker inspect container_id \[images_name\]|inspect the detail setting of the container \[images\]|



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
|docke run --link container_id| link the current container to the target|
https://docs.docker.com/engine/userguide/networking/#the-default-bridge-networkdocker

#### 文件互传

|command| use|
|----|----|
|docker cp /home/host dockerid:/home/| copy files in host to container |
|docker cp dockerid:/home /home|copy files in container to host|

        
       
基本命令：  

       
        docker inspect id 详细检查container 配置。  
       docker rm container_id;
       docker rmi image_id;
