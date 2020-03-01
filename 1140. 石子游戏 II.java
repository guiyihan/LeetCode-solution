class Solution {
    /* 用二维的动态规划来解题：分别为剩下的石子堆数i和 获取能力M
    每次行动可以拿x∈[1,2M] 堆石头，然后到对方的回合，对方能够一共获取到dp[i-x][max(x,j)]堆石头，用石堆总数减去对方的数量，就是自己的数量
    */
    public int stoneGameII(int[] piles) {
        int[][] dp=new int[piles.length+1][(piles.length+1)];
        int[] sum=new int[piles.length+1];
        int sum_num=0;
        for(int i=piles.length;i>0;i--){
            sum[piles.length-i]=sum_num;
            sum_num+=piles[i-1];
        }
        sum[piles.length]=sum_num;
        for(int i=0;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j*2>=i){
                    dp[i][j]=sum[i];
                }
                int Max=0;
                for(int x=1;x<=j*2&&x<=i;x++){
                    Max=Math.max(Max,sum[i]-dp[i-x][Math.max(x,j)]);
                }
                dp[i][j]=Max;
            }
        }
        return dp[piles.length][1];
    }
}