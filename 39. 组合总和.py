class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        out=[]
        
        def DFS(candidates,target,left,out,res):
            if target<0:
                return
            if target==0:
                res.append(out.copy())
                return
            for i in range(left,len(candidates)):
                out.append(candidates[i])
                if target>=candidates[i]:
                    DFS(candidates,target-candidates[i],i,out,res)
                out.pop()
        
        
        DFS(candidates,target,0,out,res)
        return res