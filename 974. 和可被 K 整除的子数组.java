class Solution {
    public int subarraysDivByK(int[] A, int K) {

        int[] count=new int[K];
        count[0]=1;
        int res=0;
        int sum=0;
        for(int num:A){
            sum+=num;
            sum=sum%K;
            if(sum<0){
                sum+=K;
            }
            res+=count[sum];
            count[sum]+=1;
            
        }
        return res;
    }
}