class Solution {
    public int longestValidParentheses(String s) {
        StringBuilder build =new StringBuilder(s);
        int l=0,r=0,maxlen=0;
        for(char i:s.toCharArray() ){
            if (i=='('){
                l+=1;
            }else{
                r+=1;
            }
            if (l<r){
                l=0;
                r=0;
            }else if (l==r){
                maxlen=Math.max(maxlen,l+r);
            }
        }
        l=0;
        r=0;
        for(char i:build.reverse().toString().toCharArray()){
            if (i=='('){
                l+=1;
            }else{
                r+=1;
            }
            if (l>r){
                l=0;
                r=0;
            }else if (l==r){
                maxlen=Math.max(maxlen,l+r);
            }
        }
        return maxlen;
    }
}