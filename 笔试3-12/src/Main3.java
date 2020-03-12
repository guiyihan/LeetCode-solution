import java.util.*;

/**
 * 算法复杂度为O(n*n)
 * 深度优先遍历无法保证距离最近的先被访问到，需要多个bitmap记录，所以导致超时
 * 应该使用广度优先遍历，能够保证距离最近的先被访问到
 * 本次实现未使用剪枝
 */
public class Main3 {
    static BitSet known=null;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m =s.nextInt();
        int k=s.nextInt();
        int[] mat=new int[n];
        known=new BitSet(n);
        for (int i = 0; i < n; i++) {
            mat[i]=s.nextInt()-1;
        }
        int[][] cost=new int[n][k];
        for (int i = 0; i <n ; i++) {
            Arrays.fill(cost[i],999999);
        }
        Set<Integer>[] set=new Set[n];
        for (int i = 0; i <n ; i++) {
            set[i]=new HashSet<>();
        }
        for (int i = 0; i <m ; i++) {
            int x=s.nextInt()-1;
            int y=s.nextInt()-1;
            if(x!=y){
                set[x].add(y);
                set[y].add(x);
            }
        }
        for (int i = 0; i <n ; i++) {
            dfs(set,i,0,mat[i],cost,new BitSet(n));
            known.clear();
        }
        for (int i = 0; i <n ; i++) {
            int sum=0;
            for(int j=0;j<k;j++){
                sum+=cost[i][j];
            }
            System.out.print(sum+" ");
        }


        
    }

    public static void dfs(Set<Integer>[] set, int now,int dist,int i,int[][] cost,BitSet bitSet){
        if(cost[now][i]<dist){
            return;
        }else {
            cost[now][i]=dist;
        }

        bitSet.set(now);

        for(int next:set[now]){
            if(bitSet.get(next)==false){
                dfs(set, next, cost[now][i]+1, i, cost, (BitSet) bitSet.clone());
            }

        }
    }
}
