class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[] state=new int[]{0,-prices[0],3<<30,3<<30,3<<30};
        for(int i=1;i<prices.length;i++){
            int[] newState=new int[5];
            newState[0]=0;
            newState[1]=Math.max(-prices[i],state[1]);
            newState[2]=Math.max(state[1]+prices[i],state[2]);
            newState[3]=Math.max(state[2]-prices[i],state[3]);
            newState[4]=Math.max(state[3]+prices[i],state[4]);
            state=newState;
        }
        return Math.max(state[0],Math.max(state[2],state[4]));
    }
}