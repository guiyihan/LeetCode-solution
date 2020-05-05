class Solution {
	//二分查找
    public int minTime(int[] time, int m) {
        if(m>=time.length){
            return 0;
        }
        int sum=0;
        for(int i:time){
            sum+=i;
        }
        int l=0;
        int r=sum;
        int mid;
        while(l<r){
            mid=(r+l)/2;
            if(isValid(mid,time, m)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean isValid(int bound,int[] time, int m){
        int day=1;
        int maxTime=0;
        int sum=0;
        for(int i=0;i<time.length;){
            
            maxTime=Math.max(maxTime,time[i]);
            if(sum+time[i]-maxTime<=bound){
                sum+=time[i];
                i++;
            }else{
                day++;
                sum=0;
                maxTime=0;
            }
        }
        return day<=m;
    }
}