class Solution {
	//https://leetcode-cn.com/problems/domino-and-tromino-tiling/
	//动态规划：每一列有四种状态，00,01,10,11 每种状态能够转化为下一列的四种状态
    public int numTilings(int N) {
        int[] dp=new int[]{1,0,0,0};
        int mod=1000000007;
        for(int i=0;i<N;i++){
            int[] new_dp=new int[4];
            new_dp[0]=(dp[0]+dp[3])%mod;
            new_dp[1]=(dp[0]+dp[2])%mod;
            new_dp[2]=(dp[0]+dp[1])%mod;
            new_dp[3]=((dp[0]+dp[1])%mod+dp[2])%mod;
            dp=new_dp;
        }
        return dp[0];
        
    }
}