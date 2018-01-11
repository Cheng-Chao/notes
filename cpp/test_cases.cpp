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


class later_normal{
    public:
    later_normal(pre& input){
        inst = input;
        cout<<"later const"<<endl;
    }
    
    pre inst;
};

class later_initial_list{
    public:
    later_initial_list(pre& input):inst(input){
          cout<<"later1 const"<<endl;
    }
    
    pre inst;
};



void test_initial_list(){
	pre exa(2);
	cout<<"-----------end of construct of pre---------"<<endl;
	
	later_normal exac(exa);
	
	cout<<"-----------end of construct of initialize in construct func---------"<<endl;
	
	
	later_initial_list exac_initial_list(exa);
	
	cout<<"-----------end of construct of initialize in initial list---------"<<endl;
	
}



int main()
{
	
	test_initial_list();

	return 0;
}
