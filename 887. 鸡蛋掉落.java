class Solution {
    public int superEggDrop(int K, int N) {
        if(K==0){
            return 0;
        }
        int[] dp=new int[K+1];
        int[] nextDp;
        for(int F=1; ; F++){
            nextDp=new int[K+1];
            for(int i=1;i<=K;i++){
                nextDp[i]=dp[i]+dp[i-1]+1;
                if(nextDp[i]>=N){
                    return F;
                }
            }
            dp=nextDp;
        }
        
    }
}