public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int len1=nums1.length;
        int len2=nums2.length;
        if((len1+len2)%2==1){
            return getKthElement(nums1,nums2,(len1+len2)/2+1);
        }else {
            return (getKthElement(nums1,nums2,(len1+len2)/2)+getKthElement(nums1,nums2,(len1+len2)/2+1))/2;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int p1=0;
        int p2=0;
        while(true){
            if(p1==nums1.length){
                return nums2[p2+k-1];
            }
            if(p2==nums2.length){
                return nums1[p1+k-1];
            }
            if(k==1){
                return Math.min(nums1[p1],nums2[p2]);
            }
            int nums1Mid=Math.min(p1+k/2,nums1.length)-1;
            int nums2Mid=Math.min(p2+k/2, nums2.length) -1;
            if(nums1[nums1Mid]<=nums2[nums2Mid]){
                k-=nums1Mid-p1+1;
                p1=nums1Mid+1;
            }else{
                k-=nums2Mid-p2+1;
                p2=nums2Mid+1;
            }
        }
    }
}
