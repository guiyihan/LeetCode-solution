class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            swap(nums,i);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return nums[i];
            }
        }
        
        return -1;
    }
    
    private void swap(int[] nums,int p){
        if(nums[p]==p || nums[nums[p]]==nums[p]){
            return;
        }else{
            int temp=nums[nums[p]];
            nums[nums[p]]=nums[p];
            nums[p]=temp;
            swap(nums,p);
        }
        
    }
}