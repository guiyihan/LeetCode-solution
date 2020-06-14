class Solution {
    public int findBestValue(int[] arr, double target) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            double avg=target/(arr.length-i);
            if(avg>arr[i]){
                target-=arr[i];
            }else{
                return (int)Math.ceil(avg-0.5d);
            }
        }
        return arr[arr.length-1];
    }
}