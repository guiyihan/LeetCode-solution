class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[][] dp=new int[increase.length+1][3];
        for(int i=1;i<increase.length+1;i++){
            dp[i][0]=dp[i-1][0]+increase[i-1][0];
            dp[i][1]=dp[i-1][1]+increase[i-1][1];
            dp[i][2]=dp[i-1][2]+increase[i-1][2];
        }
        int[] res=new int[requirements.length];
        for(int i=0;i<requirements.length;i++){
            for(int j=0;j<3;j++){
                int index=binarySearch(dp, j, requirements[i][j]);
                if(index==-1){
                    res[i]=index;
                    break;
                }
                res[i]=Math.max(res[i],index);
            }
            
        }
        return res;

    }

    private int binarySearch(int[][] dp, int j, int target){
        if(dp[dp.length-1][j]<target){
            return -1;
        }
        int l=0;
        int r=dp.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(dp[mid][j]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return r;
    }
}