//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
using namespace std;



class pre{
    public:
    pre(){
             cout<<"preconstr\t"<<endl;
    }
    pre(int i){
        cout<<"preconstr\t"<<i<<endl;
    }
    
    pre(const pre& input){
        cout<<"copy const pre"<<endl;
    }
    const pre& operator=(const pre& input){
        cout<<"operator = copy const pre"<<endl;
    }
};


class later{
    public:
    later(pre& input){
        inst = input;
        cout<<"later const"<<endl;
    }
    
    pre inst;
};

class later1{
    public:
    later(pre& input):inst(input){
          cout<<"later1 const"<<endl;
    }
    
    pre inst;
};


int main()
{
	pre exa(2);
	
	later exac(exa);
	return 0;
}
