class Solution {
	/*
	这道题和221题最大的正方形很类似
	用到了DP的方法
	trick：在每个右下角位置，可以确定以此点为右下角的矩形总数恰好=DP[i][j]
	*/
    public int countSquares(int[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int res=0;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0];
            res=res+dp[i][0];
        }
        for(int j=1;j<matrix[0].length;j++){
            dp[0][j]=matrix[0][j];
            res=res+dp[0][j];
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    continue;
                }else{
                    dp[i][j]=min(min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    res=res+dp[i][j];
                }
            }
        }
        return res;
    }
    public int min(int a,int b){
        if(a>b){
            return b;
        }else{
            return a;
        }
    }
}