# 8 queen quesrion
    // Example program
    #include <stdio.h>

    int q(int l,int r,int m,int n,int i,int j)
    {
        return j?i?q(l,r,m,n,i&i-1,1)+q((l|i&-i)*2,(r|i&-i)/2,m|i&-i,n,0,0):0:m-n?q(l,r,m,n,~(l|r|m)&n,1):1;
    }

    int main()
    {
        for(int n=0;n++<15;)printf("%d ",q(0,0,0,(1<<n)-1,0,0)); return 0;
    }
