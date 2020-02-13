class Solution {
	/*
	使用三个set保存所有人
	分别表示三个状态，未被遍历，已被遍历，当前圈子(buffer)
	*/
    public int findCircleNum(int[][] M) {
        int res=0;
        Set<Integer> known=new HashSet();
        Set<Integer> buffer=new HashSet();
        Set<Integer> unknown=new HashSet();
        for(int i=0;i<M.length;i++){
            unknown.add(i);
        }
        while(!unknown.isEmpty()){
            int p=unknown.iterator().next();
            unknown.remove(p);
            buffer.add(p);
            while(!buffer.isEmpty()){
                int temp=buffer.iterator().next();
                for(int i=0;i<M.length;i++){
                    if(M[i][temp]==1 && unknown.contains(i)){
                        buffer.add(i);
                        unknown.remove(i);
                    }
                }
                buffer.remove(temp);
                known.add(temp);
            }
            res+=1;
        }
        return res;
    }
}