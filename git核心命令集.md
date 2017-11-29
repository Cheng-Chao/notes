必做：
* 产生公钥：`ssh-keygen -t rsa -C "emailaddress"`将产生的.pub文件copy到网站上去
    
* 自动换行开关`git config --global core.autocrlf false`
* 建立追踪`git branch -u origin/new`  

   1. checkout to the local branch you wanna be tracked, firstly;  
   2. '-u' (not '--u') equals "--set -upstream" 
   3. "origin/new" (not "origin new")
 
核心命令集：  
* 推`git push origin local_branch_name:remote_branch_name`  
* 拉`git pull origin remote_branch_name:local_branch_name`  
* 合并远端的主分支 `git pull origin master`  
* 只fetch下来 `git fetch origin remote_branch_name:local_branch_name`  

---

* 新建并切换分支`git checkout -b newbranch`    attention: **-b**  
* 新建分支,以当前节点为基点`git branch branch_name`  
* 回退所有改变`git reset --hard`  
* 回退到前一个节点 `git reset --hard head^` 请注意^^和~2的区别  
* 回退某个文件 `git checkout path/filename`  
* 

---



    

