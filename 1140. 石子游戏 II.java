class Solution {
    public int stoneGameII(int[] piles) {
        /* 用二维的动态规划来解题：分别为剩下的石子堆数i和 获取能力M
        每次行动可以拿x∈[1,2M] 堆石头，然后到对方的回合，对方能够一共获取到dp[i-x][max(x,j)]堆石头，用 石堆总数减去对方的数量，就是自己的数量。
        因为当M很大的时候浪费了很多空间，所以此算法仍有较大的优化空间
        算法复杂度：时间复杂度O(n**3) 空间复杂度O(n**2)
        */
        int[][] dp=new int[piles.length+1][(piles.length+1)/2+1];
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
                    Max=Math.max(Max,sum[i]-dp[i-x][Math.min(Math.max(x,j),(piles.length+1)/2)]);
                }
                dp[i][j]=Max;
            }
        }
        return dp[piles.length][1];
    }
}