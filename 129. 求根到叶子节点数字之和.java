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
    int res=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        recursive(0,root);
        return res;
    }
    public void recursive(int temp, TreeNode root){
        if(root.left==null && root.right==null){
            temp=temp*10+root.val;
            res+=temp;
            return;
        }
        temp=temp*10+root.val;
        if(root.left!=null){
            recursive(temp,root.left);
        }
        if(root.right!=null){
            recursive(temp,root.right);
        }
    }
}