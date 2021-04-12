#include<bits/stdc++.h>
using namespace std;

int data;

void package(int a)
{
    a = a << 9;
    data = data | a;
}
void packsiblings(int s)
{
    s = s << 5;
    data = data | s;
}
void packchildren(int c)
{
    c = c << 1;
    data = data | c;
}
void packgender(int g)
{
    data = data | g;
}

int unpackage()
{
    return data >> 9 | 0;
}
int unpacksibling()
{
    return data >> 5 & 15;
}
int unpackchildren()
{
    return data >> 1 & 15;
}
int unpackgender()
{
    return data & 1;
}

int main()
{
    package(21);
    packsiblings(3);
    packchildren(2);
    packgender(0);

    cout << unpackage() << endl;
    cout << unpacksibling() << endl;
    cout << unpackchildren() << endl;
    cout << unpackgender() << endl;

    return 0;
}
