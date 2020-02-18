class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        nums=set(nums)
        def recursion1(nums):
            if nums == None:
                return []
            if len(nums) == 1:
                return [list(nums)]
            result = []
            for n in nums:
                next=nums.copy()
                next.remove(n)
                for i in recursion1(next):
                    i.append(n)
                    result.append(i)
            return result

        
        return recursion1(nums)