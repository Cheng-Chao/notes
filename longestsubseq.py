import random

def longestSubSeq(a):
    res = [1 for i in range(0,len(a))]
    for i,j in enumerate(a):
        for k in range(i+1):
            if a[k]<a[i]:
                res[i] =res[k]+1

    print (res)


def main():
    a = [int(random.random()*100) for i  in range(0,10)]
    print (a)

    longestSubSeq(a)

if __name__ == '__main__':
    main()
