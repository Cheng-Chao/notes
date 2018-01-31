1. 其中的reserve()成员函数。是为了提前预留空间，会提高程序速度。但是不是说开辟了size。  reserve以后vector实例的size还是0；  不能直接用下标访问。

      vector<int> res;
      res.reserve(10);
      for(int i=0;i<10;i++){
          res[i] = i;   //错误不能使用
      } 
      res.size() //0
