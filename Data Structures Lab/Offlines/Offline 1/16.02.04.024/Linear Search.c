#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main()
{
    srand(time(NULL));
    int ar[20000],i,num;
    printf("Generating array...");
    for(i=0;i<20000;i++)
    {
        ar[i]=rand()%5000;
    }
    printf("Enter an integer to search for:");
    scanf("%d",&num);
    for(i=0;i<20000;i++)
    {
        if(ar[i]==num)
        {
            printf("\nInteger found at index: %d",i);
            break;
        }

    }
    return 0;
}

