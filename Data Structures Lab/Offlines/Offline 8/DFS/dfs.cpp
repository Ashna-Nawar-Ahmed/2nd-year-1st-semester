#include<bits/stdc++.h>
#include<stdio.h>
using namespace std;

#define WHITE 0
#define GRAY 1
#define BLACK 2
#define SIZE 100

int adj[SIZE][SIZE];
int colour[SIZE];
int parent[SIZE];
int dis[SIZE];

void dfs(int vertex);
void dfsVisit(int u, int vertex);

int main()
{
    freopen("input.txt", "r", stdin);
    int vertex;
    int edge;
    scanf("%d",&vertex);
    scanf("%d",&edge);
    printf("node is %d\n",vertex);
    printf("edge is %d\n",edge);

    int node1,node2;
    for(int i = 0 ; i< edge ; i++)
    {

        scanf("%d %d",&node1,&node2);
        adj[node1][node2] = 1;

    }
    for(int i = 0 ; i < vertex ; i++)
    {
        for(int j = 0 ; j < vertex ; j++)
        {
            printf(" %d ",adj[i][j]);
        }
        printf("\n");
    }

    dfs(vertex);
}


void dfs(int vertex)
{
    for(int i = 0 ; i < vertex ; i++)
        colour[i] = WHITE;
    cout << "DFS is ";
    for(int i = 0 ; i<vertex ; i++)
    {
        if(colour[i] == WHITE)
        {
            dfsVisit(i, vertex);
        }
    }
}

void dfsVisit(int u, int vertex)
{
    colour[u] = GRAY;
    for(int i = 0 ; i<vertex ; i++)
    {
        if(adj[u][i] == 1)
        {
            int v = i;
            if(colour[v] == WHITE)
            {
                parent[v] = u;
                dfsVisit(v, vertex);
            }
        }
    }
    colour[u] = BLACK;
    printf("%d ",u);

}
