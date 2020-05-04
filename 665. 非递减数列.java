class Solution {
    public boolean checkPossibility(int[] nums) {
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(count>=1){
                    return false;
                }
                count++;
                if(max<=nums[i+1]){
                    nums[i]=max;
                }else{
                    nums[i+1]=nums[i];
                }
            }
            max=nums[i];
        }
        return true;
    }
}