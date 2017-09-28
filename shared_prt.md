
#### summary :  

* shared_ptr has 3 common constructors;
  * **shared_ptr sm_ptr(pointer);**
  * **shared_ptr sm_ptr2(sm_ptr);** the same as operator= ; this will cause the use_count()++
  * shared_ptr(pointer,destructor);  

* unique_ptr() can only be moved; can't be copy;  

      unique_ptr first(new int(10));
      unique_ptr second = std::move(first); //first is useless;


---

* shared_ptr means it can be delivered or moved and **keep the original one useful**;  

* unique_ptr becomes useless once delivered or moved;

example:  

    #include <iostream>
    #include <memory>
    int main () {
    std::shared_ptr<int> foo;                                      //define a shared_ptr;
        std::cout<<foo.use_count()<<std::endl; 
        int *tmp;
        {
            int* tmpinner = new int(10);
            tmp=tmpinner;
            
            //attention!!!
            std::cout<<*tmp<<std::endl;
            std::shared_ptr<int> bar (tmpinner);         
            foo = bar;                                            //copy the smart pointer to another;
            //attention!!!
              
            std::cout<<bar.use_count()<<std::endl;                //counter ++;   2
            std::cout<<foo.use_count()<<std::endl;                //the counters of the two keep the same ;  2
        }
      std::cout<<*tmp<<std::endl;                                 // 10  tmpinner was kept cause there is still one smart_ptr foo references to it
      std::cout<<foo.use_count()<<std::endl;                      // 1  bar was detroy in the block
    }
---
 
## unique_ptr

    // Example program
    #include <iostream>
    #include <string>
    #include <memory>
    using namespace std;
    int main()
    {
        int * first = new int(10);

        //attention!!!
        unique_ptr<int> u_ptr(first);
        unique_ptr<int> u_ptr1= move(u_ptr);
        //attention!!!

        if(!u_ptr)cout<<"u_ptr is empty()";
        //overload the bool operator to judge if(u_ptr) is empty();
        
        cout<<'\t'<<*u_ptr1;
        return 0;


    }
---

## tip:
* shared_ptr has 3 common constructors;
  * **shared_ptr sm_ptr(pointer);**
  * **shared_ptr sm_ptr2(sm_ptr);** the same as operator= ; this will cause the use_count()++
  * shared_ptr(pointer,destructor);  

* unique_ptr() can only be moved; can't be copy;  

      unique_ptr first(new int(10));
      unique_ptr second = std::move(first); //first is useless;


