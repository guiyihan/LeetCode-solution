class Solution {
	/*
	使用两个HashSet保存未访问的房间和目前获得的钥匙
	效率不高，可以使用BitSet优化
	*/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null || rooms.size()==0){
            return false;
        }
        Set<Integer> unknown=new HashSet<Integer>(rooms.size());
        for(int i=1;i<rooms.size();i++){
            unknown.add(i);
        }
        
        Set<Integer> knownKeys=new HashSet<Integer>(rooms.size());
        List<Integer> keys=new ArrayList<Integer>();
        keys.addAll(rooms.get(0));
        int i=0;
        while(i<keys.size()){
            int room=keys.get(i);
            
            unknown.remove(room);
            for(int newKey: rooms.get(room)){
                if(!knownKeys.contains(newKey)){
                    keys.add(newKey);
                    knownKeys.add(newKey);
                }
            }
            
            i++;
        }
        return unknown.isEmpty();
        

    }
	
	public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        if(rooms==null || rooms.size()==0){
            return false;
        }
        BitSet known=new BitSet(rooms.size());
        
        BitSet knownKeys=new BitSet(rooms.size());
        List<Integer> keys=new ArrayList<Integer>();
        keys.addAll(rooms.get(0));
        int i=0;
        while(i<keys.size()){
            int room=keys.get(i);
            known.set(room);
            for(int newKey: rooms.get(room)){
                if(!knownKeys.get(newKey)){
                    keys.add(newKey);
                    knownKeys.set(newKey);
                }
            }
            i++;
        }
        // System.out.println(known);
        for(int index=1;index<rooms.size();index++){
            if(!known.get(index)){
                return false;
            }
        }
        return true;
        

    }
}