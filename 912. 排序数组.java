class Solution {
    public int[] sortArray(int[] nums) {
		//quickSort(nums,0,nums.length-1);
        return mergeSort(nums);
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
    public int[] mergeSort(int[] nums){
        if(nums.length==1){
            return nums;
        }
        int[] left=Arrays.copyOfRange(nums,0,nums.length/2);
        int[] right=Arrays.copyOfRange(nums,nums.length/2,nums.length);
        mergeSort(left);
        mergeSort(right);
        for(int i=0,j=0;i<left.length||j<right.length;){
            if(i<left.length&&j<right.length){
                if(left[i]<right[j]){
                    nums[i+j]=left[i];
                    i++;
                }else{
                    nums[i+j]=right[j];
                    j++;
                }
            }
            if(i>=left.length&&j<right.length){
                nums[i+j]=right[j];
                j++;
            }
            if(j>=right.length&&i<left.length){
                nums[i+j]=left[i];
                i++;
            }
        }
        return nums;
    }
}