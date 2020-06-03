class Solution {
    public double new21Game(int N, int K, int W) {
        if(K>N){
            return 0.0;
        }
        if(K+W<N || K==0){
            return 1.0;
        }
        double[] dp=new double[K+W];
        for(int i=N;i>=K;i--){
            dp[i]=1.0;
        }
        double sum=N-K+1;
        
        for(int i=K-1;i>=0;i--){
            dp[i]=sum/W;
            sum+=dp[i];
            sum-=dp[i+W];
        }
        return dp[0];
        
    }
}