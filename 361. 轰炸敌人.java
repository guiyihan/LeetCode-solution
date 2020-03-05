class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int[][] up=new int[grid.length][grid[0].length];
        int[][] down=new int[grid.length][grid[0].length];
        int[][] left=new int[grid.length][grid[0].length];
        int[][] right=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            int num=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='E'){
                    num+=1;
                }else if(grid[i][j]=='W'){
                    num=0;
                }else{
                    left[i][j]=num;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            int num=0;
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j]=='E'){
                    num+=1;
                }else if(grid[i][j]=='W'){
                    num=0;
                }else{
                    right[i][j]=num;
                }
            }
        }
        for(int j=0;j<grid[0].length;j++){
            int num=0;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]=='E'){
                    num+=1;
                }else if(grid[i][j]=='W'){
                    num=0;
                }else{
                    up[i][j]=num;
                }
            }
        }
        for(int j=0;j<grid[0].length;j++){
            int num=0;
            for(int i=grid.length-1;i>=0;i--){
                if(grid[i][j]=='E'){
                    num+=1;
                }else if(grid[i][j]=='W'){
                    num=0;
                }else{
                    down[i][j]=num;
                }
            }
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int enemy=up[i][j]+down[i][j]+left[i][j]+right[i][j];
                res=Math.max(res,enemy);
            }
        }
        return res;
        
        
    }
}