https://blog.csdn.net/doc_sgl/article/details/8880468

    void calcCatalan(int* a, int size){
        a[0]=1;
        a[1]=1;
        int sum=0;
        for(int i = 2; i <= size; i++)  
        {  
            a[i] = 0;  
            int sum =0;
            for(int j = 0; j < i; j++)  
                sum += (a[j] * a[i-1-j]);  
            a[i] = sum;
        }  

    }


    int GetBracketMatchingNum(int nNum)
    {
        /*在这里实现功能*/
        //catalan number
        if(0 == nNum) return 0;
        int *catalan = new int[nNum+1];
        calcCatalan(catalan, nNum);

        int res = catalan[nNum];
        delete []catalan;
        return res;


    }
