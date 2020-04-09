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
    Map<Integer,Integer> dict=new HashMap();
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++){
            dict.put(inorder[i],i);
        }
        return buildTree(0,preorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildTree(int left1,int right1,int left2,int right2){
        if(left1>right1){
            return null;
        }
        TreeNode res=new TreeNode(preorder[left1]);
        int pivotIndex = dict.get(preorder[left1]);

        // 这一步得画草稿，计算边界的取值
        res.left = buildTree(left1 + 1, left1 + (pivotIndex - left2), left2, pivotIndex - 1);
        res.right = buildTree(left1 + (pivotIndex - left2) + 1, right1, pivotIndex + 1, right2);
        return res;

    }
}