# StdIO  

#### summary:  
   

     while(ret=scanf("%d %d",&a,&d)){
          cin.sync(); // pay attention 
          cout<<ret;
          cout << a <<"\t"<< d<<endl;
        }

----
 
 
优先使用scanf_s，用法和scanf一样；  
返回值为匹配到的输入个数；  
如果遇到不匹配停止读取输入流；下次读取时从该出错的地方继续读取。  

**cin.sync()函数用来清空输入流；考虑程序健壮性。**


      #include <iostream>
      using namespace std;
      int _tmain(int argc, _TCHAR* argv[])
      {
        int a;
        int d;
        int ret;

        while(ret=scanf("%d %d",&a,&d)){
          cin.sync(); // pay attention 
          cout<<ret;
          cout << a <<"\t"<< d<<endl;
        }
        cout<<ret;
        getchar();
        return 0;
    }

