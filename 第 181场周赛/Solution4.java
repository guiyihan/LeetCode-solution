public class Solution4 {
    String s;
    public String longestPrefix(String s) {
        this.s=s;
        for (int i = s.length()-1; i >=0 ; i--) {


            if(myEquals(new int[]{0,i},new int[]{s.length()-i,s.length()})){
                return s.substring(0,i);
            }
        }
        return "";
    }
    public boolean myEquals(int[] l,int[] r){
        for (int i = l[1]-l[0]-1; i >=0 ; i--) {
            if(!(s.charAt(l[0]+i) ==(s.charAt(r[0]+i)))){
                return false;
            }
        }return true;
    }

    public static void main(String[] args) {
        Solution4 s=new Solution4();
        s.longestPrefix("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
    }
}
