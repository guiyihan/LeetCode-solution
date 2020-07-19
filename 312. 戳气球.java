class Solution {
    public int maxCoins(int[] nums) {
        int[] val = new int[nums.length + 2];
        val[0] = val[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            val[i] = nums[i - 1];
        }
        nums=val;
        int[][] dp=new int[nums.length][nums.length];
        for(int length =2;length<nums.length;length++){
            for(int i=0;i<nums.length-length;i++){
                int j=i+length;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j], dp[i][k]+dp[k][j]+nums[i]*nums[k]*nums[j]);
                }
            }
        }
        return dp[0][nums.length-1];
    }
}