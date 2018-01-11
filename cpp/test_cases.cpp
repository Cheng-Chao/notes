//#include "header.h"	//AnycodeX includes the header.h by default, needn't cancle the notation.
#include <iostream>
#include "test_initial_list.h"

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
