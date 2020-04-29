/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek=findPeek(mountainArr);
        int res=binarySearch(target,0,peek,mountainArr);
        if(res==-1){
            res=binarySearchDec(target,peek,mountainArr.length(), mountainArr);
        }
        return res;
    }
    public int findPeek(MountainArray mountainArr){
        int l=0;
        int r=mountainArr.length()-1;
        int mid;
        while(l<r){
            mid=(l+r)/2;
            int t1=mountainArr.get(mid-1);
            int t2=mountainArr.get(mid);
            int t3=mountainArr.get(mid+1);
            if(t1<t2 && t2>t3){
                return mid;
            }else if(t1>t2){
                r=mid;
            }else{
                l=mid;
            }
        }
        return -1;
    }
    public int binarySearch(int target, int l,int r, MountainArray mountainArr){
        int mid;
        while(l<r){
            mid=(l+r)/2;
            int temp=mountainArr.get(mid);
            if(temp==target){
                return mid;
            }
            if(temp<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return -1;
    }
    public int binarySearchDec(int target, int l,int r, MountainArray mountainArr){
        int mid;
        while(l<r){
            mid=(l+r)/2;
            int temp=mountainArr.get(mid);
            if(temp==target){
                return mid;
            }
            if(temp>target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return -1;
    }
}