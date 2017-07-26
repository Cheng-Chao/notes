## C style 
using strtok()

    using namespace std;
    #include <iostream>
    #include <string>
    #include <string.h>
    #include <vector>
    using namespace std;
    int main()

    {

        string s="sda-sdsa-da dfsaf dfas.fgdg.gfhg,hgjh";
        const char *delimiter="-,. ";
        char *tmp=NULL;
        char *c_string=new char [s.size()+1];

        vector<string> res;
        strcpy(c_string,s.c_str());

        tmp=strtok(c_string,delimiter);;
        res.push_back(tmp);

        while(tmp=strtok(NULL,delimiter)){
              res.push_back(tmp);
        }

        vector<string>::iterator it = res.begin();
        for(;it != res.end();it++){
            cout<<*it<<"\t";
        }

      return 0;
    }
---
## C++ style#include <iostream>
      #include <string>
      #include <string.h>
      #include <vector>
      using namespace std;

      void SpliceStr(const string input, const string delimiter,vector<string>& res ){
        if(input.size()==0||delimiter.size()==0) return ;
        int last_position = 0 ,position = 0;
        res.clear();

        while(position != string::npos)
        {
          position =input.find_first_of(delimiter,last_position);
          string tmp = input.substr(last_position,position-last_position); //position-last_position 可能<0;substr函数会将<0的整数，当做string::npos;
          res.push_back(tmp);
          last_position = position+1;
        }



      }
      int main()
      {
        string s="sda-sdsa-da dfsaf dfas.fgdg.gfhg,hgjh";
        const char *delimiter="- ,.";
        char *tmp=NULL;
        char *c_string=new char [s.size()+1];

        vector<string> res;
        SpliceStr(s,delimiter,res);

        vector<string>::iterator it = res.begin();
        for(;it != res.end();it++){
          cout<<*it<<"\t";
        }

        return 0;
      }




