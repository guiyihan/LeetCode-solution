class Solution {
    int mintime;
    double prob;
    List<Integer>[] g;
    BitSet set;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        set=new BitSet(n+1);
        g=new List[n+1];
        for (int i = 1; i <n+1 ; i++) {
            g[i]=new ArrayList<>();
        }
        for (int i = 0; i <edges.length ; i++) {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        if(target==1){
            if(g[1].size()>0&& t>=1){
                return 0d;
            }
            return 1d;
        }
        g[1].add(1);
        dfs(g[1],target,0,1d,1);
        if(t<mintime){
            return 0d;
        }else if(t>mintime && (g[target].size()>1)){
            return 0d;
        }else{
            return prob;
        }
    }
    public void dfs(List<Integer> root, int target, int time, double prob,int rootindex){
        if(root.isEmpty()){
            return;
        }
        set.set(rootindex);
        time++;
        prob=prob/(root.size()-1);
        for(int node:root){
            if(node==target){
                this.mintime=time;
                this.prob=prob;
                return;
            }else{
                if(!set.get(node)) {
                    dfs(g[node], target, time, prob,node);
                }
            }
        }
    }
}