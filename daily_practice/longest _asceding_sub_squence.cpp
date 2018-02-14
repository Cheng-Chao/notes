#include <algorithm>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <iterator>
using namespace std;
#define SIZE (10)
int a[SIZE];
typedef ostream_iterator<int> out;
int res[SIZE];

int longest_asce_subsqu(int *a){
        for(int i=0;i<SIZE;i++){
                for(int j=0;j<i;j++){
                        if(a[i]>a[j]){
                                res[i] = max(res[j]+1,res[i]);
                        }
                }

        }
        for(int i=0;i<SIZE;i++){
                res[i]+=1;
        }
        copy(res,res+SIZE,out(cout, " "));
        cout<<endl;
        return *max_element(res,res+SIZE);

}


int main(){
        srand(time(NULL));
        for(int i =0 ;i<SIZE;i++){
                a[i] = rand()%100;
        }


        copy(a,a+SIZE,out(cout, " "));
        cout<<endl;
        cout<<longest_asce_subsqu(a);




}
