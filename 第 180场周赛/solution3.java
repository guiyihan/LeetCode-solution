package LeetCode_solution.competition2;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class solution3 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list=new ArrayList<>();
        toArray(root);
        return rebuild(0,list.size()-1);
    }
    public  void toArray(TreeNode root){
        if(root==null){
            return;
        }
        toArray(root.left);
        list.add(root);
        toArray(root.right);
    }
    public TreeNode rebuild (int left,int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=list.get(mid);
        root.left=rebuild(left,mid-1);
        root.right=rebuild(mid+1,right);
        return root;
    }
}