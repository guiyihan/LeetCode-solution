class Solution {
    public int numTimesAllBlue(int[] light) {
        int blue=0;
        int res=0;

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <light.length ; i++) {
            set.add(light[i]);
            while(set.contains(blue+1)){
                blue++;
                set.remove(blue);
            }
            if(set.isEmpty()){
                res+=1;
            }
        }
        return res;
    }
}