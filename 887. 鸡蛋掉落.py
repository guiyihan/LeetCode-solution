class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        dp=[[1]*K,[0]*K]
        res=1
        j=1
        while max(dp[0][-1],dp[-1][-1])<N:
            dp[j][0]=dp[1-j][0]+1
            for i in range(1,K):
                dp[j][i]=dp[1-j][i]+dp[1-j][i-1]+1
            res+=1
            j=(j+1)%2
        return res