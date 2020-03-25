class Solution {
    public int surfaceArea(int[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                res+=surface(i,j,grid);
            }
        }

        return res;
    }
    public int surface(int i,int j, int[][] grid){
        if(grid[i][j]==0){
            return 0;
        }
        int res=grid[i][j]*4+2;
        if(i-1>=0){
            res-=Math.min(grid[i-1][j],grid[i][j]);
        }
        if(i+1<grid.length){
            res-=Math.min(grid[i+1][j],grid[i][j]);
        }
        if(j-1>=0){
            res-=Math.min(grid[i][j-1],grid[i][j]);
        }
        if(j+1<grid[0].length){
            res-=Math.min(grid[i][j+1],grid[i][j]);
        }
        
        return res;
    }
}