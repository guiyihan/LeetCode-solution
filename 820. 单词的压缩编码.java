class Solution {
	/*
	字典树的方法，把倒置的单词加入树中
	然后遍历每个叶子节点，将深度相加，得到结果
	*/
    TrieNode root=new TrieNode();
    int res=0;
    public int minimumLengthEncoding(String[] words) {
        if(words==null||words.length==0){
            return 0;
        }
        for(String word:words){
            root.add(word,word.length()-1);
        }
        getlength(root,0);
        return res;
    }
    public void getlength(TrieNode root, int length){
        if(root==null){
            return;
        }
        length++;
        boolean hasChild=false;
        for(TrieNode child:root.children){
            if(child!=null){
                getlength(child,length);
                hasChild=true;
            }
        }
        if(!hasChild){
            res+=length;
        }
        return;
    }
}
class TrieNode{
    TrieNode[] children=new TrieNode[26];
    public TrieNode(){
        
    }
    public void add(String s, int i){
        if(i<0){
            return;
        }
        char c=s.charAt(i);
        if(children[c-'a']==null){
            children[c-'a']=new TrieNode();
        }
        children[c-'a'].add(s,i-1);
        
    }
}