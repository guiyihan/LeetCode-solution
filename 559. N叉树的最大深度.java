/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution1 {
    int maxDepth;
    public int maxDepth(Node root) {
        maxDepth=0;
        DFS(root,0);
        return maxDepth;
    }
    public void DFS(Node root,int currentDepth) {
        if(root==null){
            return;
        }
        currentDepth+=1;
        this.maxDepth=Math.max(maxDepth,currentDepth);
        for(Node child : root.children){
            DFS(child,currentDepth);
        }
        
    }
}

class Solution2 {
	/*
	无需借助辅助函数，利用子树的高度+1，向上传递结果。
	*/
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int res=0;
        for(Node child:root.children){
            res=Math.max(res,maxDepth(child));
        }
        return res+1;
    }

}