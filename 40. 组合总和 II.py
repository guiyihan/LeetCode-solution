class Solution:
	##回溯法：使用target减去当前遍历到的数值得到新的target，新的target在数组的后半段递归寻找结果
	##https://pic.leetcode-cn.com/5a8ad63b91ea09d46ac0b44cbf3325c2a3c2199ec232ec562135fbcf2ea9e70d-40-1.png
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(begin, path, residue):
            if residue == 0:
                res.append(path[:])
                return

            for index in range(begin, size):
                if candidates[index] > residue:
                    break

                if index > begin and candidates[index - 1] == candidates[index]:
                    continue

                path.append(candidates[index])
                dfs(index + 1, path, residue - candidates[index])
                path.pop()

        size = len(candidates)
        if size == 0:
            return []

        candidates.sort()
        res = []
        dfs(0, [], target)
        return res
