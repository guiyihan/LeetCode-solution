class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[][] dp =new int[matrix.length][matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dfs(dp,matrix,i,j,Integer.MIN_VALUE);
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    private int dfs(int[][] dp,int[][] matrix, int i ,int j, int preValue){
        if(i<0 || j<0 || i>=dp.length || j>=dp[0].length || dp[i][j]==-1 || matrix[i][j]<=preValue){
            return 0;
        }
        if(dp[i][j]>0){
            return dp[i][j];
        }
        dp[i][j]=-1;
        int l=dfs(dp,matrix,i-1,j,matrix[i][j]);
        int r=dfs(dp,matrix,i+1,j,matrix[i][j]);
        int u=dfs(dp,matrix,i,j-1,matrix[i][j]);
        int d=dfs(dp,matrix,i,j+1,matrix[i][j]);
        dp[i][j]=Math.max(Math.max(l,r),Math.max(u,d))+1;
        return dp[i][j];
    }
}
