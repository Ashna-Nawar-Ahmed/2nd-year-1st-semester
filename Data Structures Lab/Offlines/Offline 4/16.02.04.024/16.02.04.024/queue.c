#include<stdio.h>
void push();
void pop();
int queue[1000],front=0,size,valPush,valPop,back=-1;
int main()
{
    int choice,i;
    printf("Queue size:");
    scanf("%d",&size);
    printf("Queue Operation Choices:\n1: Push\n2: Pop\n3: Display queue\n4: Exit");
    do
    {
        printf("\nEnter choice and press ENTER:");
        scanf("%d",&choice);
        switch(choice)
        {
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
        {
            for(i=0; i<=back; i++)
                printf("%d\n",queue[i]);
        }
        case 4:
            exit(0);
        default:
            printf("Wrong input!");
        }
    }while(choice!=4||size!=back);

        return 0;
}
void push()
{
    if(back>=size-1)
        printf("\nQueue full");
    else
    {
        printf("\nEnter a value to be pushed:");
        scanf("%d",&valPush);
        back++;
        queue[back]=valPush;

    }
}
void pop()
{
    int i;
    if(back<=-1)
        printf("\nQueue empty");
    else
    {
        valPop=queue[front];
        for(i=front;i<=back;i++)
        {
            queue[front]=queue[front+1];
        }
        printf("\nPopped value: %d\n",valPop);
        back--;

    }
}


