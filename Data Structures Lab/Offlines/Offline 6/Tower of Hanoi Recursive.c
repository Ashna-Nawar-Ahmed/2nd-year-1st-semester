#include<stdio.h>
void Hanoi(int n,int i,int j,int k);
int main()
{
    int n;
    printf("Enter number of disks:");
    scanf("%d",&n);
    Hanoi(n,1,2,3);
    return 0;
}

void Hanoi(int n,int i,int j,int k)
{
    if(n==1)
        printf("Move disk %d from pole %d to pole %d\n",n,i,k);
    else
    {
        Hanoi(n-1,i,k,j);
        printf("Move disk %d from pole %d to pole %d\n",n,i,k);
        Hanoi(n-1,j,i,k);
    }
}

