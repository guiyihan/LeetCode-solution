class Solution(object):
    def lengthOfLIS_n2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
		简单的动态规划
        """
        if nums==[]:
            return 0
        dp=[0]*len(nums)
        for i in range(len(nums)):
            for j in range(0,i):
                if nums[j]<nums[i]:
                    dp[i]=max(dp[i],dp[j])
            dp[i]+=1
        return max(dp)
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
		复杂度O(nlogn)，使用二分插入替换更小的值
        """
        if nums==[]:
            return 0
        lis=[]
        for i in nums:
            
            l,r=0,len(lis)
            mid=(l+r)//2
            while l!=r:
                if lis[mid]<i:
                    l=mid+1
                    mid=(l+r)//2
                else:
                    r=mid
                    mid=(l+r)//2
                
            if r<len(lis):
                lis[r]=i
            else:
                lis.append(i)
        return len(lis)