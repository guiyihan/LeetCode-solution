class Solution {
//这道题看起来简单，实际上还是有一定技巧，需要将重叠问题转化为不重叠问题（因为重叠的情况太复杂了）
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   
                 rec1[3] <= rec2[1] ||  
                 rec1[0] >= rec2[2] ||   
                 rec1[1] >= rec2[3]);
        
    }

}