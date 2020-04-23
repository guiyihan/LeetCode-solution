class Solution {
	/*
	简单的dp问题，01背包问题，从右至左扫描是否能够满足总和的要求
	*/
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2==1){
            return false;
        }
        boolean[] dp=new boolean[(sum)/2+1];
        dp[0]=true;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp+=nums[i];
            for(int j=Math.min(sum/2,temp);j>=nums[i];j--){
                dp[j]=dp[j-nums[i]] || dp[j];
            }
        }
        return dp[sum/2];
    }
}