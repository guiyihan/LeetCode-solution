class Solution {
    // dfs遍历，使用三种颜色012对访问的节点进行记录
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph =new List[numCourses];
        boolean res=true;
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int[] edge: prerequisites){
            graph[edge[1]].add(edge[0]);
        }
        int[] dp=new int[numCourses];// 0:未遍历 1：灰度 2：已遍历
        for(int i=0;i<numCourses;i++){
            res = res && noLoop(graph,dp,i);
        }
        return res;
    }

    private boolean noLoop(List<Integer>[] graph, int[] dp, int i){
        if(dp[i]==2){
            return true;
        }else if(dp[i]==1){
            return false;
        }else{
            dp[i]=1;
            boolean res=true;
            for(int next: graph[i]){
                res = res && noLoop(graph,dp,next);
            }
            dp[i]=2;
            return res;
        }
    }
}

class Solution {
// bfs遍历，不断地将没有入边的节点加入答案
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        List<Integer>[] lists=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            lists[i]=new ArrayList<Integer>();
        }
        Deque<Integer> deque=new LinkedList<Integer>();
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]+=1;
            lists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int course=deque.pop();
            numCourses-=1;
            for(int c:lists[course]){
                inDegree[c]-=1;
                if(inDegree[c]==0){
                    deque.push(c);
                }
            }
        }
        return numCourses==0;
    }
}