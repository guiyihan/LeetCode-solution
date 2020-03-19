class Solution {
	/*
	例如：[4,5,6,7,0,1,2]
	使用简单的二分查找，mid=(l+r)/2向下取整，可以寻找到最大值，然后向右找到最小值
	*/
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int l=0;
        int r=nums.length-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        int mid=0;
        while(l<r){
            
            mid=l+(r-l)/2;
            if(nums[mid]>nums[l]){
                l=mid;
            }else{
                r=mid;
            }
            
        }
        return nums[r+1];
    }
}