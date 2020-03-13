class Solution {
	\*
	使用二维的DP保存一下累计的前缀和（2维）
	这样可以O(1)的复杂度判断一个正方形中数的总和
	利用结果的side只增不减的性质，小于side的正方形就需要不考虑了
	*\
    public int maxSideLength(int[][] mat, int threshold) {
        int side=0;
        int[][] dp=new int[mat.length+1][mat[0].length+1];
        
        
        for(int i=1;i<mat.length+1;i++){
            for(int j=1;j<mat[0].length+1;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+mat[i-1][j-1];
            }
        }
        for(int i=1;i<mat.length+1;i++){
            for(int j=1;j<mat[0].length+1;j++){
                while(i-side-1>=0&&j-side-1>=0&&dp[i][j]-(dp[i-side-1][j]+dp[i][j-side-1])+dp[i-side-1][j-side-1]<=threshold){
                    side++;
                }

            }
        }
        return side;

    }
}