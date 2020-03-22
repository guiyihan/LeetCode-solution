import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for (int num:nums
             ) {
            res+=fourD(num);
        }
        return res;
    }
    public int fourD(int num){

        Set<Integer> set=new HashSet<>();
        int res=0;
        for (int i = 1; i <=(int) Math.sqrt(num)+1 ; i++) {
            if(num%i==0){
                set.add(i);
                set.add(num/i);

            }
            if(set.size()>4){
                return 0;
            }
        }
        if(set.size()==4){
            for (int i:set
                 ) {
                res+=i;
            }
            return res;
        }
        return 0;

    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        solution2.sumFourDivisors(new int[]{6,7,8,9,10} );
    }
}
