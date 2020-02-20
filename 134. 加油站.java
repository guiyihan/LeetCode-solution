class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int temp=0;
        for(int i=0;i<gas.length;i++){
            gas[i]=gas[i]-cost[i];
            temp+=gas[i];
        }
        if(temp<0){
            return -1;
        }
        int oil=0;
        int res=-1;
        for(int i=0;i<gas.length;i++){
            if(oil+gas[i]<0){
                oil=0;
                res=i;
            }else{
                oil=oil+gas[i];
            }
        }
        return res+1;
    }
}