import java.util.Scanner;

public class Main2 {
    /**
     * 本题使用BFS解决
     * 初始化距离矩阵dpi 为-1
     * 第一次遍历无需使用跳跃；从起点起遍历所有能到达的位置，并记录距离
     * 第二次遍历整个地图，如果对角位置的距离+1 < 当前位置距离，更新为最小；如果当前位置为-1，说明无法直接走到，需要借助跳跃，如果对角不为-1，本位距离=对角位置的距离+1；对本位置进行BFS搜索
     * 第三次遍历整个地图，重复第二次遍历的步骤一样
     * 第四次遍历整个地图，重复第二次遍历的步骤一样
     * 第五次遍历整个地图，重复第二次遍历的步骤一样
     * 第六次遍历整个地图，重复第二次遍历的步骤一样
     *
     * 如果第六次遍历仍然无法找到END，此时跳跃次数用尽，返回-1；
     * @param args
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int M=s.nextInt();
        char[][] dp=new char[N][M];
        int [] start=new int[2];
        int [] end=new int[2];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j]= s.next().charAt(0);
                if(dp[i][j]=='S'){
                    start[0]=i;
                    start[1]=j;
                }
                if(dp[i][j]=='E'){
                    end[0]=i;
                    end[1]=j;
                }
            }
        }
        int[][] dpi=new int[N][M];
        bfs(dp,dpi,start[0],start[1],1);
        bfs(dp,dpi,N-start[0],M-start[1],2);

        System.out.print(dpi[end[0]][end[1]]);
    }
    public static void bfs(char[][] dp, int[][] dpi, int i, int j, int step){
        if(i<0||i>=dp.length||j<0||j>=dp[0].length){
            return;
        }
        if(dp[i][j]=='#' || dpi[i][j]>0){
            return;
        }
        dpi[i][j]=Math.min(dpi[i][j],step);
        bfs(dp,dpi,i+1,j,step+1);
        bfs(dp,dpi,i,j+1,step+1);
        bfs(dp,dpi,i,j-1,step+1);
        bfs(dp,dpi,i-1,j,step+1);
    }
}
