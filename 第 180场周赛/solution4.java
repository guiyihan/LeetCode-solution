package LeetCode_solution.competition2;

import java.util.*;

class Solution4 {
	/*
	按照efficiency从高到低排序，对于每一个点i来说，取出排在其前面最大的K个值求和 X efficiency[i]就是最大值
	算法复杂度：时间O(nlogn) 空间O(logn)
	*/
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            queue.add(items[i][0]);
            sum += items[i][0];
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            res = Math.max(res, sum * items[i][1]);
        }
        return (int) (res % ((int) 1e9 + 7));
    }


    public static void main(String[] args) {
        maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2);
    }
}
