

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


