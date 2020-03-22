import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> res=new ArrayList();
        for(int i=0;i<nums.length;i++){
            res.add(index[i],nums[i]);
        }
        int[] rtn=new int[nums.length];
        for(int i=0;i<rtn.length;i++){
            rtn[i]=res.get(i);
        }
        return rtn;
    }
}
