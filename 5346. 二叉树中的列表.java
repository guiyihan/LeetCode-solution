/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
	/*
	深度优先递归
	根据网上的提示，改了一下代码的排版，更加的美观了；
	*/
	
    boolean res=false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }
        return recursive(head,root)||isSubPath(head, root.left)||isSubPath(head, root.right);
        
    }
    public boolean recursive(ListNode head, TreeNode root){
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(head.val!=root.val){
            return false;
        }
        return recursive(head.next,root.left)||recursive(head.next,root.right);
    }
}