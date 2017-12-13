

---

---


#### plink  在远端机器上执行命令

#### 文件目录以树形展示2层`tree -L 2`
1. 注意大写L

---

#### sftp   命令(只要能用ssh登录就可以用是ssh协议族之一)(winscp---基于ssh协议的，图形化界面软件)

1. 通过本地的shell登录远端机器 sftp root@100.100.100.100
2. lls本地文件浏览；ls远端目录文件浏览(加l的命令是本地目录lpwd)
3. `put local_file remote_file`
4. `get remote_file local_file`

---
#### linux --change user priority
---

##### chmod --- change mode   
chmod 777 拥有人；所在组；所有人。 执行；读；写。  
+增加权限；-取消权限；  

        chmod +rwx file_name == chmod 777 file_name  
        
for> read, write, exec;  

---

##### chown --- change owner
        chown user:user_group file_name
        chown -R user:user_group ./   //递归更改当前目录所有权。  
        
---
---

#### grep zhaojinz <zhao.txt  找含有zhaojinz的所有行  

---

#### find . -iname zhaojinzhou.txt   .是相对路径； iname忽略大小写按名字查找； 文件名

---

#### VIM 常用
* wq / q! : 保存修改关闭 / 不保存修改关闭
* esc v : visual模式
* d delete 删除
* p paste
*  vim 搜索 / or ？+字符串
* 显示行数 ：set number
* 到第几行  ：25   到25行
* u :undo
* crtl + r :  redo 

---

#### 添加用户和默认目录

* 查看用户组信息    $ cat /etc/group  

* sudo useradd zhaojinzhou -d /home/zhaojinzhou 
  passwd zhaojinzhou                                 //设置密码  
  
* sudo userdel -r newuser //删除用户

* uname -a 简要信息  
  cat /proc/version 内核版本  
  cat /etc/passwd 当前系统用户

* commond & run in background

* whereis filename 查找文件

* du  
 显示文件大小  
   
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

* Xmanger 连接suse https://jingyan.baidu.com/article/454316ab52f679f7a7c03a39.html  
教程中/etc/sysconfig/displaymanage应为/etc/sysconfig/displaymanager
#### 不常用场景

* 
