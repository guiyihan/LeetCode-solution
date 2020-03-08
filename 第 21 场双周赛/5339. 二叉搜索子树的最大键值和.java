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
    public int maxSumBST(TreeNode root) {
        recursive(root);
        return max;
    }
    public int[] recursive(TreeNode root){

        int[] res=new int[]{root.val,root.val,root.val,0};
        if(root.left!=null){
            int[] left=recursive(root.left);
            if(left[3]==1){
                res[3]=1;

            }else if(left[2]>=root.val){
                res[3]=1;
            }else{
                res[0]+=left[0];
                res[1]=left[1];
            }
        }
        if(root.right!=null){
            int[] right=recursive(root.right);
            if(right[3]==1){
                res[3]=1;

            }else if(right[2]<=root.val){
                res[3]=1;

            }else{
                res[0]+=right[0];
                res[1]=Math.max(res[2],right[2]);
            }
        }
        if(res[3]==0){
            this.max=Math.max(max,res[0]);
        }
        
        return res;
    }
}