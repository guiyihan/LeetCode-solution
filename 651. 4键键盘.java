class Solution {
    //动态规划，每次+1或者粘贴j次
    public int maxA(int N) {
        int[] dp=new int[N+1];
        for(int i=1;i<=N;i++){
            int temp=dp[i-1]+1;
            for(int j=0;j<=Math.min(5,i-3);j++){
                temp=Math.max(temp,dp[i-3-j]*(j+2));
            }
            dp[i]=temp;
        }
        return dp[N];
    }
}