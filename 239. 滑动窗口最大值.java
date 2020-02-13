class Solution {
	/* 
	使用双向队列保存滑动窗口
	Trick：在队列尾部插入新元素，插入前删除所有小于新元素的旧元素
	队首元素即为最大值
	*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        
        if(n<k||k==0||n==0){
            return new int[0];
        }
        int [] res=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<Integer>();
        for(int i=0;i<k;i++){
            while(deque.size()>0 && nums[i]>=deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0]=deque.peekFirst();

        
        for(int i=k;i<n;i++){
            
            if(deque.peekFirst()==nums[i-k]){
                deque.pollFirst();
            }
            while(deque.size()>0 && nums[i]>deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }
}

class Solution2 {
	/* 
	使用动态规划的方法，具有一定的技巧性
	答案详解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
	思想：从左至右；从右至左的两个数组保存窗口内的最大值，使用K作为left，right数组的遍历窗口大小
	*/
  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k == 0) return new int[0];
    if (k == 1) return nums;

    int [] left = new int[n];
    left[0] = nums[0];
    int [] right = new int[n];
    right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      // from left to right
      if (i % k == 0) left[i] = nums[i];  // block_start
      else left[i] = Math.max(left[i - 1], nums[i]);

      // from right to left
      int j = n - i - 1;
      if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
      else right[j] = Math.max(right[j + 1], nums[j]);
    }

    int [] output = new int[n - k + 1];
    for (int i = 0; i < n - k + 1; i++)
      output[i] = Math.max(left[i + k - 1], right[i]);

    return output;
  }
}