#include<stdio.h>
#include<stdlib.h>
#include<time.h>
clock_t start,end;
int countComparison=0,countMovement=0,ar[20000];
int main()
{
    srand(time(NULL));
    int c,i,temp;
    printf("Generating random numbers...\n");
    for(i=1;i<=20000;i++)
    {
        ar[i]=rand();

    }
    printf("Sorting numbers...\n");

    bubble(ar);

    printf("Sorted numbers:\n");
    for(i=1;i<=20000;i++)
    {
        printf("%d\n",ar[i]);
    }

    double time=(end-start)/CLOCKS_PER_SEC;
    printf("Time taken=%lf seconds\n",time);
    printf("Number of data comparison:%d\n",countComparison);
    printf("Number of data movement:%d\n",countMovement);

    return 0;
}
void bubble(int ar[20000])
{

    int i,j,temp,k,t;
    start=clock();

    k=20000;
    while(k!=0)
    {
        t=0;
        for(j=1;j<=k-1;j++)
        {
            countComparison++;
            if(ar[j]>ar[j+1])
            {
                temp=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=temp;
                t=j;
                countMovement++;
            }

        }
        k=t;
    }
    end=clock();

}
