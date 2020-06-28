import java.util.Arrays;

public class LeetCode75 {

        public static int[] sortColors(int[] nums) {
            int l=0;
            int r=nums.length-1;
            int p=0;
            while(p<=r){
                if(nums[p]==2){
                    int temp=nums[p];
                    nums[p]=nums[r];
                    nums[r]=temp;
                    r--;
                }else if(nums[p]==0){
                    int temp=nums[p];
                    nums[p]=nums[l];
                    nums[l]=temp;
                    l++;
                    p++;
                }else {
                    p++;
                }
            }
            return nums;
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));
    }
}
