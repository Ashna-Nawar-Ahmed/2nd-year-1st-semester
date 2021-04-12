#include<stdio.h>
void push();
void pop();
int stack[1000],top=-1,size,valPush,valPop;
int main()
{
    int choice,i;
    printf("Stack size within 1000:");
    scanf("%d",&size);
    printf("Stack Operation Choices:\n1: Push\n2: Pop\n3: Display stack\n4: Exit");
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
            for(i=top; i>=0; i--)
                printf("%d\n",stack[i]);
            break;
        }
        case 4:
            exit(0);
        default:
            printf("Wrong input!");
        }
    }while(choice!=4||size!=top);

        return 0;
}
void push()
{
    if(top>=size-1)
        printf("\nStack overflow");
    else
    {
        printf("\nEnter a value to be pushed:");
        scanf("%d",&valPush);
        top++;
        stack[top]=valPush;

    }
}
void pop()
{
    if(top<=-1)
        printf("\nStack underflow");
    else
    {
        valPop=stack[top];
        printf("\nPopped value: %d",valPop);
        top--;
    }
}

