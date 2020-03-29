package Date_3_29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {
    static int max=0;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int[] nums=new int[N+1];
        for (int i = 1; i < N+1; i++) {
            nums[i]=s.nextInt();
        }
        List<Integer>[] graph=new ArrayList[N+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <N-1 ; i++) {
            int l=s.nextInt();
            int r=s.nextInt();
            graph[l].add(r);
            graph[r].add(l);
        }
        for (int i = 1; i <N ; i++) {
            dfs(graph,nums,i,0);
        }
        System.out.println(max);



    }
    public static void dfs(List<Integer>[] graph,int[] nums,int now,int len){
        len+=1;
        max=Math.max(max,len);
        List<Integer> nexts=graph[now];
        for (int next:nexts ) {
            if(nums[next]>nums[now]){
                dfs(graph,nums,next,len);
            }
        }
    }
}
