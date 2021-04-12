#include<stdio.h>
#include<stdlib.h>
#include<time.h>
void bubble(int ar[20000]);
void binarySearch(int num);

int ar[20000];
int checked=0;
int i,j;

int main()
{
    int num;
    srand(time(NULL));
    printf("Generating 20000 random numbers...");
    for(i=1;i<20000;i++)
    {
        ar[i]=rand()%10000;
    }
    printf("\nSorting numbers...");
    bubble(ar);
    printf("\nSorted numbers:\n");
    for(j=1;j<20000;j++)
    {
        printf("%d\n",ar[j]);
    }
    printf("Enter a number to search for:");
    scanf("%d",&num);
    binarySearch(num);
    return 0;
}


void binarySearch(int num)
{
    int first=0, last=19999, middle;
    while(first<=last)
    {
        middle=(first+last)/2;
        if(num==ar[middle])
        {
            printf("Number Found!");
            break;
        }
        else if(num>ar[middle])
        {
            first=middle+1;

        }
        else
        {
            last=middle-1;

        }
    }
    if(first>last)
        printf("Number not found!");
}
void bubble(int ar[20000])
{

    int i,j,temp,k,t;

    k=20000;
    while(k!=0)
    {
        t=0;
        for(j=1;j<=k-1;j++)
        {
            if(ar[j]>ar[j+1])
            {
                temp=ar[j];
                ar[j]=ar[j+1];
                ar[j+1]=temp;
                t=j;
            }

        }
        k=t;
    }

}
