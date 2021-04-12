#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void selectionSort(int ar[20000],int n);
int ar[20000],dataMovement=0,dataComparison=0;
clock_t start,end;
int main()
{
    srand(time(NULL));
    int i,n;

    printf("Enter number of elements of array:");
    scanf("%d",&n);
    printf("\nGenerating elements of array...");
    for(i=1; i<=n; i++)
        ar[i]=rand();
    selectionSort(ar,n);
    printf("\nElements of array after arranging:\n");
    for(i=1; i<=n; i++)
        printf("%d\n",ar[i]);
    printf("Time taken: %f",(end-start)/CLOCKS_PER_SEC);
    printf("\nNumber of data Comparison:%d",dataComparison);
    printf("\nNumber of data Movement:%d",dataMovement);

    return 0;

}
void selectionSort(int ar[20000],int n)
{
    int i,j,k,temp,t;
    start=clock();
    for(j=n; j>=2; j--)
    {
        t=1;
        for(k=2; k<=j; k++)
        {
            dataComparison++;
            if(ar[t]<ar[k])
            {
                t=k;
            }
        }
        temp=ar[t];
        ar[t]=ar[j];
        ar[j]=temp;
        dataMovement=dataMovement+3;


    }
    end=clock();
}

