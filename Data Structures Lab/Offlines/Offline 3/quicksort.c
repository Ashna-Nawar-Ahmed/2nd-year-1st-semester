#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int countComparison=0,countMovement=0,ar[20000];
clock_t start,end;
void quickSort(int first,int last)
{
    int i, j, temp;
    if(first<last)
    {
        i=first+1;
        countComparison++;
        while(ar[i]>ar[first])
        {
            countComparison++;
            i++;
        }
        j=last;
        countComparison++;
        while(ar[j]<ar[first])
        {
            countComparison++;
            j--;
        }
        while(i<j)
        {
            temp=ar[i];
            ar[i]=ar[j];
            ar[j]=temp;
            countMovement=countMovement+3;
            countComparison++;
            while(ar[i]>=ar[first])
            {
                countComparison++;
                i++;
            }
            countComparison++;
            while(ar[j]<=ar[first])
            {
                countComparison++;
                j--;
            }
        }
        temp=ar[first];
        ar[first]=ar[j];
        ar[j]=temp;
        countMovement=countMovement+3;
        quickSort(first,j-1);
        quickSort(j+1,last);

    }
}

int main()
{
    srand(time(NULL));
    int i, n;
    printf("Number of elements of array: ");
    scanf("%d",&n);
    printf("\nGenerating %d elements...", n);
    for(i=1; i<=n; i++)
        ar[i]=rand();
    start=clock();
    printf("\nSorting %d elements...", n);
    quickSort(1,n);
    end=clock();
    printf("\nSorted elements:\n");
    for(i=1; i<=n; i++)
        printf("%d\t",ar[i]);
    printf("\nTime Taken:%lf",(end-start)/CLOCKS_PER_SEC);
    printf("\nNumber of data comparison:%d\n",countComparison);
    printf("Number of data movement:%d\n",countMovement);
    return 0;
}

