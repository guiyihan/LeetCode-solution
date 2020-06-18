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
    public TreeNode recoverFromPreorder(String S) {
        return recursion(S.toCharArray(),0,S.length(),0);
    }

    private TreeNode recursion(char[] arr, int l,int r, int depth){
        if(l>=r){
            return null;
        }

        int start=l+depth;
        for(;start<r;start++){
            if(arr[start]=='-'){
                break;
            }
        }
        String firstNum=new String(Arrays.copyOfRange(arr,l+depth,start));
        TreeNode root=new TreeNode(Integer.parseInt(firstNum));
        int count=0;
        int split=r;
        for(int i=start+1;i<r;i++){
            if(arr[i]=='-'){
                count++;
            }else{
                if(count==depth+1){
                    split= i-(depth+1);
                }
                count=0;
            }
        }
        root.left=recursion(arr, start, split,depth+1);
        root.right=recursion(arr, split, r, depth+1);
        return root;
    }
}