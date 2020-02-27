class Solution {
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
    public void quickSort(int[] nums, int left, int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        int p=left;
        left+=1;
        while(left<=right){
            while(left<=right && nums[right]>=nums[p]){
                right-=1;
            }
            if(left<=right && nums[right]<nums[p]){
                int temp=nums[p];
                nums[p]=nums[right];
                nums[right]=temp;
                p=right;
                right-=1;
            }
            while(left<=right && nums[left]<=nums[p]){
                left+=1;
            }
            if(left<=right && nums[left]>nums[p]){
                int temp=nums[p];
                nums[p]=nums[left];
                nums[left]=temp;
                p=left;
                left+=1;
            }
            
        }
        quickSort(nums,l,p-1);
        quickSort(nums,p+1,r);
        
    }
}