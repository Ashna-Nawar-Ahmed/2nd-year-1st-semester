#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>
void merge(int ar[20000],int p,int q,int r);
void mergeSort(int ar[20000],int p,int r);
int countComparison=0,countMovement=0,ar[20000];
clock_t start,end;
int main()
{
    srand(time(NULL));
    int n,i;
    printf("Enter number of elements to be sorted:");
    scanf("%d",&n);
    printf("\nGenerating array...");
    for(i=1; i<=n; i++)
        ar[i]=rand();
    start=clock();
    mergeSort(ar,1,n);
    end=clock();
    printf("\nSorted array:\n");
    for(i=1; i<=n; i++)
        printf("%d\n",ar[i]);
    printf("\nTime Taken:%lf",(end-start)/CLOCKS_PER_SEC);
    printf("\nNumber of data comparison:%d\n",countComparison);
    printf("Number of data movement:%d\n",countMovement);

    return 0;

}
void merge(int ar[20000],int p,int q,int r)
{
    int n1,n2,i,j,k;
    n1=q-p+1;
    n2=r-q;
    int left[n1],right[n2];
    for(i=1; i<=n1; i++)
    {
        left[i]=ar[p+i-1];
        countMovement++;
    }
    for(j=1; j<=n2; j++)
    {
        right[j]=ar[q+j];
        countMovement++;
    }
    left[n1+1]=999999999;
    right[n2+1]=9999999999;
    i=1;
    j=1;
    for(k=p; k<=r; k++)
    {
        countComparison++;
        if(left[i]<=right[j])
        {
            ar[k]=left[i];
            i++;
            countMovement++;
        }
        else
        {
            ar[k]=right[j];
            j++;
            countMovement++;
        }
    }
}
void mergeSort(int ar[20000],int p,int r)
{
    int q;
    if(p<r)
    {
        q=floor((p+r)/2);
        mergeSort(ar,p,q);
        mergeSort(ar,q+1,r);
        merge(ar,p,q,r);
    }
}
