#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void insertionSort(int ar[20000],int n);
int dataMovement=0,dataComparison=0,ar[20000];
clock_t start,end;
int main()
{
    srand(time(NULL));
    int temp,i,n,t;

    printf("Enter number of elements of array:");
    scanf("%d",&n);
    printf("\nGenerating elements of array...");
    for(i=1; i<=n; i++)
        ar[i]=rand();
    insertionSort(ar,n);
    printf("\nElements of array after arranging:\n");
    for(i=1; i<=n; i++)
        printf("%d\n",ar[i]);
    printf("Time taken: %f",(end-start)/CLOCKS_PER_SEC);
    printf("\nNumber of data Comparison:%d",dataComparison);
    printf("\nNumber of data Movement:%d",dataMovement);

    return 0;

}
void insertionSort(int ar[20000],int n)
{
    int i,j,k,temp;
    ar[0]=-1;
    start=clock();
    for(j=2; j<=n; j++)
    {
        i=j-1;
        temp=ar[j];
        dataMovement++;
        dataComparison++;
        while(temp<ar[i])
        {
            ar[i+1]=ar[i];
            dataMovement++;
            i=i-1;
        }
        ar[i+1]=temp;
        dataMovement++;
    }

    end=clock();
}


