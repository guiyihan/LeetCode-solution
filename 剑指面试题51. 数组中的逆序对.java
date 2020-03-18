class Solution {
    int cnt=0;
    public int reversePairs(int[] nums) {
        mergesort(nums);
        return cnt;
    }
    public int[] mergesort(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int[] left=mergesort(Arrays.copyOfRange(arr,0,arr.length/2));
        int[] right=mergesort(Arrays.copyOfRange(arr,arr.length/2,arr.length));
        int[] res=new int[left.length+right.length];
        int i=0;
        int l=0;
        int r=0;
        while(i<res.length){
            if(l<left.length &&r<right.length){
                if(left[l]>right[r]){
                    res[i]=right[r];
                    i++;
                    r++;
                    cnt+=left.length-l;
                }else{
                    res[i]=left[l];
                    i++;
                    l++;
                }
            }
            if(l==left.length&&i<res.length){
                res[i]=right[r];
                i++;
                r++;
            }
            if(r==right.length&&i<res.length){
                res[i]=left[l];
                i++;
                l++;
            }
        }
        return res;
    }
}