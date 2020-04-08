class Solution {
    int res=0;
    public int movingCount(int m, int n, int k) {
        boolean[][] dp=new boolean[m][n];
        dfs(0,0,k,dp);
        return res;
    }
    public void dfs(int i,int j, int k, boolean[][] dp){
        if(checkBorder(i,j,k,dp)){
            res+=1;
            dp[i][j]=true;
            dfs(i+1,j,k,dp);
            dfs(i,j+1,k,dp);
        }else{
            
        }
    }
    public boolean checkBorder(int i,int j,int k, boolean[][] dp){
        if(i>=dp.length||j>=dp[0].length||dp[i][j]==true){
            return false;
        }
        int sum=0;
        while(i>0||j>0){
            sum+=i%10+j%10;
            i/=10;
            j/=10;
        }
        if(sum>k){
            return false;
        }
        return true;
    }
}