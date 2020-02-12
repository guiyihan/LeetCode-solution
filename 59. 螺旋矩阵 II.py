class Solution:
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        
        res=[[0 for i in range(n)] for i in range(n)]
        left=0
        up=0
        right=n-1
        down=n-1
        val=1
        
        while True:
            for i in range(left,right+1):
                res[up][i]=val
                val+=1
            up+=1
            if up>down:
                break
            for i in range(up,down+1):
                res[i][right]=val
                val+=1
            right-=1
            if right<left:
                break
            
            for i in range(right,left-1,-1):
                res[down][i]=val
                val+=1
            down-=1
            if down <up:
                break
            for i in range(down,up-1,-1):
                res[i][left]=val
                val+=1
            left+=1
            if left>right:
                break
        return res