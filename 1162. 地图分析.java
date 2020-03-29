class Solution {
	//由于图中没有障碍物，所以可以使用动态规划的方法，从左上到右下，从右下到左上，两次遍历，计算最近的陆地
    public int maxDistance(int[][] grid) {
        int N=grid.length;
        int M=grid[0].length;
        int[][] dp=new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==0){
                    dp[i][j]=1<<30;
                }else{
                    dp[i][j]=0;
                }  
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==0){
                    if(i>0){dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+1);}
                    if(j>0){dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);}
                    
                }else{
                }
            }
        }
        for(int i=N-1;i>=0;i--){
            for(int j=M-1;j>=0;j--){
                if(grid[i][j]==0){
                    if(i<N-1){dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);}
                    if(j<M-1){dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);}
                    
                }else{
                }
            }
        }
        int res=-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==0){
                    res=Math.max(res,dp[i][j]);    
                }
            }
        }
        if(res==1<<30){
            return -1;
        }
        return res;
    }
}