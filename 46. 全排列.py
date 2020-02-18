class Solution:

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.reverse()

        def recursion1(nums):
            if nums == None:
                return []
            if len(nums) == 1:
                return [nums]
            result = []
            for n in nums:
                next=nums.copy()
                next.remove(n)
                for i in recursion1(next):
                    i.append(n)
                    result.append(i)
            return result

        
        return recursion1(nums)