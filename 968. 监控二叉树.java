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
    //动态规划，节点的三种状态：0未被监控但子节点被监控，1被子节点监控，2此处有监控
    public int minCameraCover(TreeNode root) {
        int[] res=dfs(root);
        return Math.min(res[1],res[2]);
    }
    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0,1};
        }
        int[] res=new int[3];
        int[] left=dfs(root.left);
        int[] right=dfs(root.right);
        res[0]=left[1]+right[1];
        res[1]=Math.min(left[2]+Math.min(right[1],right[2]),right[2]+Math.min(left[1],left[2]));
        res[2]=Math.min(Math.min(left[1],left[0]),left[2])+Math.min(Math.min(right[1],right[0]),right[2])+1;
        return res;
    }
}