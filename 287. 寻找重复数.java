class Solution {
    //本题有较高的技巧性，因为数字都在1-n之间，所以从index:0出发肯定无法回到0，会进入到一个环中
    public int findDuplicate(int[] nums) {
        int fast=nums[nums[0]];
        int slow=nums[0];
        while(fast!=slow){
            fast=nums[fast];
            fast=nums[fast];
            slow=nums[slow];
        }
        
        fast=0;
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return slow;
    }
}