
#### 添加用户和默认目录
* sudo useradd -d /home/zhaojinzhou -s /bin/bash zhaojinzhou  
  passwd 密码    //设置密码  

* uname -a 简要信息  
  cat /proc/version 内核版本  
  cat /etc/passwd 当前系统用户

* commond & run in background

* whereis filename 查找文件
  vim 搜索 / or ？+字符串
   
* apt-get purge 和 romve -f 区别 purge 更彻底

* ssh name@remoteserver 命令行登录远程linux机器

#### 常用的软件
* boot_repair    ---- 修复boot  

----  

* vsftpd         ---- ftpserver  [安装服务教程](http://www.krizna.com/ubuntu/setup-ftp-server-on-ubuntu-14-04-vsftpd/)  
  note:
  550 Permission denied  
  原因：vsftp默认配置不允许上传文件。  
  解决：修改/etc/vsftpd.conf,将“write_enable=YES”前面的#取消,重启vsftp服务器。  

----

* uget+aria2     ---- download


#### 不常用场景

* 
