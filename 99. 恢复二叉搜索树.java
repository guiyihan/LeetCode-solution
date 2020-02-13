/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 主要思路为：中序遍历整个二叉搜索树
 本题目有一定的trick，通过两个指针node1,node2记录两个位置有问题的节点，preNode代表目前遍历到的节点的前继节点；
 问题节点的判断标准：一号节点为：节点值大于后节点的节点，二号节点为小于前节点的节点；
 例如：
 中序遍历的结果：[1, 4, 3, 2, 5]
 "4"和"2"是问题节点
 本次解法在只有两个节点时仍然有效。
 */
class Solution {
    TreeNode node1,node2,preNode;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(preNode!=null && preNode.val>root.val){
            if(node1==null){
                node1=preNode;
            }
            node2=root;
            
        }
        preNode=root;
        inorder(root.right);
    }
}