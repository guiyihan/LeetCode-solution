/*
引用自：https://www.nowcoder.com/discuss/389640?type=post&order=time&pos=&page=1
AC 代码
空间复杂度O(m*n*6), 时间复杂度O(m*n*6)
考试时写的比较草率，没有好好做函数化，简单加点注释供讨论
简单来说思路是类似于广度优先搜索的，但也写成了偏dp的样子……
dp[i][j][k]：对于位置i,j，用了k次飞行器时，达到这个位置最小需要的步数
用队列来进行访问：
1. 首先把起点坐标放入队列
2. 每一次访问队头元素，观察其1步可以到达的（上、下、左、右、中心对称位）的坐标：
   如果该坐标当前记录的某一种飞行器使用次数k下的值>当前值+1，则更新该值，把这一坐标加入队列
   （注意，上、下、左、右是同k值比较，中心对称位需要使用一次飞行器，所以是k+1和K比较）
3. 队列清空，更新完成
给出终点目前记录的步数，即为结果
*/
 
/*
可能的优化：
因为队列入队时，肯定越到后面步数需要越多，所以其实第一次访问到终点坐标就可以跳出了，
不过已经AC了就不想改了……
*/


#include <bits/stdc++.h>
using namespace std;
 
//定义坐标点
struct pos{
    int x;
    int y;
};
 
struct ks {
    int use[6];
};
 
//初始化每个位置达到所需步数
void init_dpmat(vector<vector<ks> > &dp, int n, int m) {
    ks ktmp;
    vector<ks> dp_r;
    int i;
    for(i = 0; i < 6; i++) {
        ktmp.use[i] = 250001;
    }
    for(i = 0; i < m; i++) {
        dp_r.push_back(ktmp);
    }
    for(i = 0; i < n; i++) {
        dp.push_back(dp_r);
    }
    return;
}
 
//记录起点、终点
void init_queue(vector<vector<ks> > &dp, queue<pos> &q1, int i, int j) {
    pos ps;
    ps.x = i;
    ps.y = j;
    int k;
    for(k = 0; k < 6; k++) {
        dp[i][j].use[k] = 0;
    }
    q1.push(ps);
    return;
}
 
pos end_pos(int i, int j) {
    pos pe;
    pe.x = i;
    pe.y = j;
    return pe;
}
 
//检查是否可行点
bool check(pos ptmp, vector<vector<char> > &M) {
    return (ptmp.x >= 0 && ptmp.x < M.size() &&
            ptmp.y >= 0 && ptmp.y < M[0].size() &&
            M[ptmp.x][ptmp.y] != '#');
}
 
//bfs case
bool bfs_case(queue<pos> &q1, vector<vector<char> > &M, vector<vector<ks> > &dp,
                                              int mode[4][2], int casenum, int casecate, pos pe) {
    pos ptmp;
    if(casecate == 0) {
        ptmp.x = q1.front().x + mode[casenum][0];
        ptmp.y = q1.front().y + mode[casenum][1];
    }
    else {
        ptmp.x = int(M.size() - 1) - q1.front().x;
        ptmp.y = int(M[0].size() - 1) - q1.front().y;
    }
     
    int k;
    bool flag;
    if(check(ptmp, M)) {
        flag = 0;
        for(k = 0; k < 6 - casecate; k++) {
            if(dp[ptmp.x][ptmp.y].use[k + casecate] > dp[q1.front().x][q1.front().y].use[k] + 1) {
                dp[ptmp.x][ptmp.y].use[k + casecate] = dp[q1.front().x][q1.front().y].use[k] + 1;
                flag = 1;
            }
        }
        if(flag == 1) {
            q1.push(ptmp);
        }
    }
    if(ptmp.x == pe.x && ptmp.y == pe.y) {
        return 1;
    }
    else {
        return 0;
    }
}
 
int main() {
    int n,m;
    cin>>n>>m;
     
    char ctmp;
    vector<char> vtmp;
    vector<vector<char> > M;
     
    vector<vector<ks> > dp;
    init_dpmat(dp, n, m);
     
    queue<pos> q1;
    pos pe;
     
    int mode[4][2] = {-1,0,0,-1,1,0,0,1};
     
    bool flag;
    int i,j;
     
    //输入 && 记录起点、终点
    for(i = 0; i < n; i++) {
        for(j = 0; j < m; j++) {
            cin>>ctmp;
            vtmp.push_back(ctmp);
            if(ctmp == 'S') {
                init_queue(dp, q1, i, j);
            }
            else if(ctmp == 'E') {
                pe = end_pos(i,j);
            }
        }
        M.push_back(vtmp);
        vtmp.clear();
    }
     
    //广度优先遍历，如可达终点点则输出
    while(!q1.empty()) {
        flag = 0;
        for(i = 0; i < 4; i++) {
            flag = flag | bfs_case(q1, M, dp, mode, i, 0, pe);
        }
        flag = flag | bfs_case(q1, M, dp, mode, 0, 1, pe);
         
        if(flag) {
            cout<<dp[pe.x][pe.y].use[5]<<endl;
            return 0;
        }
        q1.pop();
    }
    //不能达到终点，输出-1
    cout<<-1<<endl;
    return 0;
}