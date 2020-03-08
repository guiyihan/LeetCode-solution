class Solution {
    int max=0;
    List<Integer>[] info;
    int[] informTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        info=new List[n];
        for (int i = 0; i <n ; i++) {
            info[i]=new ArrayList<>();
        }
        for (int i = 0; i <manager.length ; i++) {
            if(manager[i]>=0){
                info[manager[i]].add(i);
            }

        }
        recursive(info[headID],informTime[headID]);
        return max;


    }
    public void recursive(List<Integer> manager,int time){
        if(manager.isEmpty()){
            max=Math.max(max,time);
            return;
        }
        for(int employee: manager){
            recursive(info[employee],time+informTime[employee]);
        }

    }
}