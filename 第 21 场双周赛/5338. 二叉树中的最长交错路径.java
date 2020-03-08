/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max=0;
    public int longestZigZag(TreeNode root) {
        int[] res=recursive(root);
        return max;
    }
    public int[] recursive(TreeNode root){
        if(root==null){
            return new int[]{-1,-1};
        }
        int[] res=new int[2];
        res[0]+=recursive(root.left)[1]+1;
        res[1]+=recursive(root.right)[0]+1;
        max=Math.max(Math.max(res[0],res[1]),max);
        return res;
    }
}