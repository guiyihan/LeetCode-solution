class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length+1];
        int[] temp=new int[days.length+1];
        for(int i=1;i<temp.length;i++){
            temp[i]=days[i-1];
        }
        days=temp;
        for(int i=1;i<days.length;i++){
            dp[i]=dp[i-1]+costs[0];
            int j=0;
            while(i-j>0&&days[i-j]+7>days[i]){
                j++;
            }
            dp[i]=Math.min(dp[i],dp[i-j]+costs[1]);
            while(i-j>0&&days[i-j]+30>days[i]){
                j++;
            }
            dp[i]=Math.min(dp[i],dp[i-j]+costs[2]);
        }
        
        return dp[dp.length-1];
    }
}