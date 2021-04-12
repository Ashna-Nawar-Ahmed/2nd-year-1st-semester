#include<stdio.h>

int main()
{
    int info =0;
    int age, sex, kids, siblings;

    printf("Enter Age: ");
    scanf("%d", &age);

    printf("\nEnter kids: ");
    scanf("%d", &kids);

    printf("\nEnter Siblings: ");
    scanf("%d", &siblings);

    printf("\nEnter Sex 0 for Male 1 for Female: ");
    scanf("%d", &sex);

    age=age<<9;
    kids = kids<<5;
    siblings = siblings<<1;
    info = age | kids | siblings | sex;


    printf("\nAge is %d", info>>9 & 127);
    printf("\nKids are: %d", info>>5 & 15);
    printf("\nSiblings are: %d", info>>1 & 15);

    if(sex==0)
    {
        printf("\nSex is Male");
    }
    else
        printf("\nSex if Female");


    return 0;
}
