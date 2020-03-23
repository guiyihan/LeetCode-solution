class Solution {
	/*
	技巧性强，需要把用一根线把圆圈分成两部分求解
	图解见：
	https://leetcode-cn.com/problems/handshakes-that-dont-cross/solution/dp-by-mike-meng-16/
	*/
    public int numberOfWays(int num_people) {
        long mod=1000000007;
        long[] dp=new long[num_people+1];
        dp[0]=1L;
        for(int i=2;i<=num_people;i+=2){
            long temp=0;
            for(int j=0;j<i;j+=2){
                temp=temp%mod+(dp[i-j-2]*dp[j])%mod;//注意dp[]*dp[]是很有可能超过32位的，因此需要使用long整数
                temp=temp%mod;
            }
            dp[i]=temp;
        }
        return (int)dp[num_people];
    }
}