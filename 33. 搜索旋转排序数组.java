class Solution {
    public int search (int[] nums, int input){
        if(nums.length==1 && nums[0]==input){
            return 0;
        }
            
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]==input){
                return  mid;
            }
            if(nums[left]==input){
                return  left;
            }
            if(nums[right]==input){
                return  right;
            }
            if(nums[left]<=nums[mid]  ){
                if(input>nums[left]&&nums[mid]>input){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
                
            }else if( nums[right]>=nums[mid]){
                if(nums[mid]<input&& input<nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
                
            }
        }
        return -1;
    }
}