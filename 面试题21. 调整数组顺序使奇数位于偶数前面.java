class Solution {
	/*
	剑指offer21题
	使用两个指针，均从前往后出发，相比较一个从前一个从后而言速度下降
	*/
    public int[] exchange(int[] nums) {
        if(nums.length==0){
            return nums;
        }
        int p1=0;
        int p2=0;
        while(p1<nums.length&& (nums[p1]&0x1)==0){
            p1+=1;
        }
        while(p2<nums.length&&(nums[p2]&0x1)==1){
            p2+=1;
        }
        while(p1<nums.length && p2<nums.length){
            if(p1>p2){
                int temp=nums[p2];
                nums[p2]=nums[p1];
                nums[p1]=temp;
            }else{
                p1+=1;
            }
            while(p1<nums.length&&(nums[p1]&0x1)==0){
                p1+=1;
            }
            while(p2<nums.length&&(nums[p2]&0x1)==1){
                p2+=1;
            }
        }
        return nums;
        
    }
}