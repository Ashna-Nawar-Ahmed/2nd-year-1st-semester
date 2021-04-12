#include<bits/stdc++.h>
#include<stdio.h>
using namespace std;

#define WHITE 0
#define GRAY 1
#define BLACK 2
#define SIZE 100

int adj[SIZE][SIZE];
int colour[100];
int parent[100];
int dis[100];
void bfs(int adj[SIZE][SIZE],int vertex, int startingNode);

void printPath(int startingNode, int endNode);

int main()
{
    int vertex;
    int edge;

    freopen("input.txt", "r", stdin);

    scanf("%d",&vertex);
    scanf("%d",&edge);
    printf("node is %d\n",vertex);
    printf("edge is %d\n",edge);
    int node1,node2;
    for(int i = 0 ; i< edge ; i++)
    {
        scanf("%d %d",&node1,&node2);
        adj[node1][node2] = 1;
        adj[node2][node1] = 1;

    }
    for(int i = 0 ; i < vertex ; i++)
    {
        for(int j = 0 ; j < vertex ; j++)
        {
            printf(" %d ",adj[i][j]);
        }
        printf("\n");
    }
    bfs(adj,vertex, 0);
    printf("\n");
    printf("the path is\n");
    printPath(0, 7);
}

void bfs(int adj[SIZE][SIZE],int vertex, int startingNode)
{
    for(int i = 0 ; i < vertex ; i++)
    {
        if(i!= startingNode)
        {
            colour[i] = WHITE;
            dis[i] = INT_MIN;
            parent[i] = NULL;
        }
    }

    colour[startingNode] = GRAY;
    dis[startingNode] = 0;
    parent[startingNode] = -1;
    queue <int> bfsQueue;
    bfsQueue.push(startingNode);
    //cout << "BFS is : ";
    printf("Bfs is: ");
    while(!bfsQueue.empty())
    {
        int u = bfsQueue.front();
        printf("%d ",u);
        bfsQueue.pop();
        for(int i = 0 ; i < vertex ; i++)
        {
            if(adj[u][i]!=0)
            {
                int v = i;
                if(colour[v] == WHITE)
                {
                    colour[v] = GRAY;
                    dis[v] = dis[u]+1;
                    parent[v] = u;
                    bfsQueue.push(v);
                }
            }
        }
        colour[u] = BLACK;
    }

}

void printPath(int s, int v)
{
    if(v==s)
    {
        printf("%d\t",s);
    }
    else
    {
        printPath( s, parent[v]);
        printf("%d\t",v);
    }
}

