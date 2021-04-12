#include<stdio.h>
#include<stdlib.h>
#include<time.h>
clock_t start,end;
int countComparison=0,countMovement=0,ar[20000];
int main()
{
    srand(time(NULL));
    int c,i,temp,n;
    float median;
    printf("Enter number of elements of array:");
    scanf("%d",&n);
    printf("Generating %d random numbers...\n",n);
    for(i=1;i<=n;i++)
    {
        ar[i]=rand();

    }
    printf("Sorting numbers...\n");

    bubble(ar,n);

    printf("Sorted numbers:\n");
    for(i=1;i<=n;i++)
    {
        printf("%d\n",ar[i]);
    }
    if(n%2==0)
    {
        median=(ar[n/2]+ar[(n/2)+1])/2;
        printf("Median is=%f\n",median);
        printf("Median is at index=%d and %d\n",(n/2)-1,(n/2));
    }
    else
    {
         median=ar[(n/2)+1];
         printf("Median is=%f\n",median);
         printf("Median is at index=%d\n",(n/2));
    }




    return 0;
}
void bubble(int ar[1000],int x)
{

    int i,j,temp,k,t;
    start=clock();

    k=x;
    while(k!=0)
    {
        t=0;
        for(j=1;j<=k-1;j++)
        {
            countComparison++;
            if(ar[j]<ar[j+1])
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
