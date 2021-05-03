# Tarjan算法 求无向连通图的割点

【**网易有道笔试题**】
给定一个无向连通图，求其割点数量。
【**进阶**】
求出每个割点所分出的连通分量数

## 暴力解法

割点的定义是`若除去此节点和与其相关的边，无向图不再连通`。最简单暴力的做法是，依次将每个点从图中去掉，再使用DFS判断图的连通性。但这种方法的时间复杂度过高，会达到$O(N(N+E))$.

## tarjan算法

该部分的详细过程可参考这篇文章[tarjan求割点](https://zhuanlan.zhihu.com/p/269306969),文章写的简洁易懂，值得一看。

```c++
#include <bits/stdc++.h>
#define ll long long
using namespace std;
const int maxn=20000+10;//最大节点数
int n,m;//节点数与边数
vector<int>e[maxn];//vector存图
int dfn[maxn],low[maxn];//含义如上阐述
int cut[maxn];//表示某点是否是割点
int dfs_clock;//全局变量记录dfs序
void tarjan(int now,int root,int fa)//记录当前节点、树的根节点、父节点
{
    dfn[now]=low[now]=++dfs_clock;
    //初始时，low[now]=dfn[now]
    int child=0;//记录该节点的孩子数
    for(int i=0;i<e[now].size();i++)
    {
        int to=e[now][i];
        if(!dfn[to])//若to尚未访问过
        {
            child++;//to是now的孩子
            tarjan(to,root,now);//向下遍历
            low[now]=min(low[now],low[to]);//更新now
            if(low[to]>=dfn[now]&&now!=root) cut[now]=1;
            //判断是否是割点
        }
        else if(to!=fa) low[now]=min(low[now],dfn[to]);
        //若to已访问过，且to不是父节点，则to是祖先节点
    }
    if(child>=2&&now==root) cut[now]=1;
    //根节点的特判
}
int main()
{
    scanf("%d%d",&n,&m);
    for(int i=1;i<=m;i++)
    {
        int u,v;
        scanf("%d%d",&u,&v);
        e[u].push_back(v);
        e[v].push_back(u);
    }//读入无向图
    dfs_clock=0;//初始化
    for(int i=1;i<=n;i++)
        if(!dfn[i]) tarjan(i,i,-1);
    //若给的是多个图的情况
    int cnt=0;
    for(int i=1;i<=n;i++) if(cut[i]) cnt++;
    printf("%d\n",cnt);
    for(int i=1;i<=n;i++) if(cut[i]) printf("%d ",i);
    printf("\n");
    return 0;
}
```

```c++
//求解联通分量数
void tarjan(int now,int root,int fa)//记录当前节点、树的根节点、父节点
{
    dfn[now]=low[now]=++dfs_clock;
    //初始时，low[now]=dfn[now]
    int child=0;//记录该节点的孩子数
    for(int i=0;i<e[now].size();i++)
    {
        int to=e[now][i];
        if(!dfn[to])//若to尚未访问过
        {
            child++;//to是now的孩子
            tarjan(to,root,now);//向下遍历
            low[now]=min(low[now],low[to]);//更新now
            if(low[to]>=dfn[now]&&now!=root) cut[now]++;
            //判断是否是割点，与其满足条件的孩子数
        }
        else if(to!=fa) low[now]=min(low[now],dfn[to]);
        //若to已访问过，且to不是父节点，则to是祖先节点
    }
    if(child>=2&&now==root) cut[now]=child;
    //根节点的特判
    if(cut[now]&&now!=root) cut[now]++;
}
```

# 