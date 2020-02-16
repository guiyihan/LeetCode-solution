class Solution {
	/*指针从左下角逐次移动到右上角（这样处理边界问题更为简单）
	复杂度=m+n
	可以用二分搜索优化到：m+log(n)
	*/
    public int countNegatives(int[][] grid) {
        int res=0;
        int i=grid.length-1;
        int j=0;
        while(j<=grid[0].length-1 && i>=0){
            if(grid[i][j]>=0){
                j+=1;
                
            }else{
                res+=grid[0].length-j;
                System.out.println(res);
                i-=1;
                
            }
        }
        return res;
    }
}