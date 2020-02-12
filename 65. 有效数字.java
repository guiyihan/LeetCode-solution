class Solution {
    public boolean isNumber(String s) {
        if(s.charAt(s.length()-1)>'A' && s.charAt(s.length()-1)<'z'){
                return false;
            }
        try{
            Double.parseDouble(s);
            return true;
        }catch(Exception e){

            
            return false;
        }
        
    }
}