#include<stdio.h>
#include<stdlib.h>
#include<time.h>
clock_t start,end;
int countComparison=0,countMovement=0,ar[25000];
int main()
{
    srand(time(NULL));
    int c,i,temp,n;
    double time_bubble,time_insertion,time_selection,time_merge,time_quick;
    int count_bubble,count_insertion,count_selection,count_merge,count_quick,move_bubble,move_insertion,move_selection,move_merge,move_quick;
    printf("Enter number of elements of array:");
    scanf("%d",&n);
    printf("\nGenerating elements of array...");
    for(i=1; i<=n; i++)
        ar[i]=rand();
    printf("Sorting numbers...\n");

    start=clock();
    bubble(ar,n);
    end=clock();
    time_bubble=(end-start)/CLOCKS_PER_SEC;
    count_bubble=countComparison;
    move_bubble=countMovement;

    start=clock();
    insertionSort(ar,n);
    end=clock();
    time_insertion=(end-start)/CLOCKS_PER_SEC;
    count_insertion=countComparison;
    move_insertion=countMovement;

    start=clock();
    selectionSort(ar,n);
    end=clock();
    time_selection=(end-start)/CLOCKS_PER_SEC;
    count_selection=countComparison;
    move_selection=countMovement;

    start=clock();
    quickSort(1,n);
    end=clock();
    time_quick=(end-start)/CLOCKS_PER_SEC;
    count_quick=countComparison;
    move_quick=countMovement;

    start=clock();
    mergeSort(ar,1,n);
    end=clock();
    time_merge=(end-start)/CLOCKS_PER_SEC;
    count_merge=countComparison;
    move_merge=countMovement;

    printf("\n\n\nSorting Technique\tNo.of data movement\t\tNo.of data comparison\t\tTime Taken\n");
    printf("\nBubble Sort\t\t\t%d\t\t\t%d\t\t%lf",move_bubble,count_bubble,time_bubble);
    printf("\nInsertion Sort\t\t\t%d\t\t\t%d\t\t%lf",move_insertion,count_insertion,time_insertion);
    printf("\nSelection Sort\t\t\t%d\t\t\t%d\t\t%lf",move_selection,count_selection,time_selection);
    printf("\nQuick Sort\t\t\t%d\t\t\t%d\t\t%lf",move_quick,count_quick,time_quick);
    printf("\nMerge Sort\t\t\t%d\t\t\t%d\t\t%lf",move_merge,count_merge,time_merge);

    return 0;
}
void bubble(int ar[20000],int n)
{

    int i,j,temp,k,t;


    k=n;
    while(k!=0)
    {
        t=0;
        for(j=1; j<=k-1; j++)
        {
            countComparison++;
            if(ar[j]>ar[j+1])
            {
                temp=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=temp;
                t=j;
                countMovement=countMovement+3;
            }

        }
        k=t;
    }


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
        countMovement++;
        countComparison++;
        while(temp<ar[i])
        {
            ar[i+1]=ar[i];
            countMovement++;
            i=i-1;
        }
        ar[i+1]=temp;
        countMovement++;
    }

    end=clock();
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
            countComparison++;
            if(ar[t]<ar[k])
            {
                t=k;
            }
        }
        temp=ar[t];
        ar[t]=ar[j];
        ar[j]=temp;
        countMovement=countMovement+3;


    }
    end=clock();
}
void quickSort(int first,int last)
{
    int i, j, temp;

    if(first<last)
    {

        i=first+1;
        countComparison++;
        while(ar[i]<ar[first])
        {
            countComparison++;
            i++;
        }
        j=last;
        countComparison++;
        while(ar[j]>ar[first])
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
            while(ar[i]<=ar[first])
            {
                countComparison++;
                i++;
            }

            countComparison++;
            while(ar[j]>=ar[first])
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

