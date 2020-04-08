class Main3{
    public String sub (String s){
        char[] chars=s.toCharArray();
        int head=0;

        int maxLen=0;
        String result="";
        Map<Character,Integer> dict=new HashMap();
        for(int i=0;i<chars.length;i++){
            if(dict.containsKey(chars[i])){
                head=Math.max(dict.get(chars[i])+1,head);
            }
            dict.put(chars[i],i);
            if(i-head+1>maxLen){
                maxLen=i-head+1;
                result=s.substring(head,i+1);
            }

        }
        return result;
    }
}