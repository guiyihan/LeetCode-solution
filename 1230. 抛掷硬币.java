class Solution {
    /**本题要求将所有的硬币全部抛完以后计算概率，所以并不需要考虑硬币的顺序
     *
     * @param prob
     * @param target
     * @return
     */
    public double probabilityOfHeads(double[] prob, int target) {
        if(prob==null || target>prob.length|| prob.length==0){
            return 0d;
        }
        double[][] dp=new double[target+1][prob.length+1];
        dp[0][0]=1d;
        for(int i=1;i<=target;i++){
            dp[i][0]=0d;
        }
        for(int j=1;j<=prob.length;j++){
            dp[0][j]=dp[0][j-1]*(1-prob[j-1]);
        }
        for(int i=1;i<=target;i++){
            for(int j=1;j<=prob.length;j++){
                dp[i][j]=dp[i-1][j-1]*prob[j-1]+dp[i][j-1]*(1-prob[j-1]);
            }
        }
        return dp[target][prob.length];
    }
}
