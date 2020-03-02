class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[] state=new int[]{0,-prices[0],0};
        for(int i=0;i<prices.length;i++){
            int[] nextState=new int[3];
            nextState[0]=Math.max(state[0],state[1]+prices[i]);
            nextState[1]=Math.max(state[1],state[2]-prices[i]);
            nextState[2]=state[0];
            state=nextState;
        }
        return Math.max(state[0],state[2]);
    }
}