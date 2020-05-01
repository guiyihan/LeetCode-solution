class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int i:hand){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        List<Integer> list1=new ArrayList<>(count.keySet());
        Collections.sort(list1);
        if(list1.size()<W){
            return false;
        }
        for(int i=0;i<list1.size()-W+1;){
            for(int j=list1.get(i);j<list1.get(i)+W;j++){
                if(!count.containsKey(j)||count.get(j)==0){
                    return false;
                }else{
                    count.put(j,count.get(j)-1);
                }
            }
            while(i<list1.size()&&(!count.containsKey(list1.get(i))||count.get(list1.get(i))==0)){
                i++;
            }
        }
        for(int i=list1.size()-W;i<list1.size();i++){
            if(count.get(list1.get(i))!=0){
                return false;
            }
        }
        return true;
    }
}