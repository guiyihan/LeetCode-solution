class Solution {
    public String[] findWords(String[] words) {
        List<Character> list1=Arrays.asList('Q','W','E','R','T','Y','U','I','O','P','q','w','e','r','t','y','u','i','o','p');
        List<Character> list2=Arrays.asList('A','S','D','F','G','H','J','K','L','a','s','d','f','g','h','j','k','l');
        HashSet<Character> row1=new HashSet(list1);
        HashSet<Character> row2=new HashSet(list2);
        List<String> res=new ArrayList();
        for(String s:words){
            if(s.length()==0){
                continue;
            }
            int temp=find(s.charAt(0),row1,row2);
            for(char c: s.toCharArray()){
                if(temp!=find(c,row1,row2)){
                    temp=-1;
                    break;
                }
            }
            if(temp!=-1){
                res.add(s);
            }
        }
        return res.toArray(new String[]{});
    }
    public int find(char c, Set<Character> set1, Set<Character> set2){
        if(set1.contains(c)){
            return 1;
        }else if(set2.contains(c)){
            return 2;
        }else{
            return 3;
        }
    }
}