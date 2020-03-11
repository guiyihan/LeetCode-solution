class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        List<Integer> stack=new ArrayList();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[i]>=stack.get(stack.size()-1)){
                stack.remove(stack.size()-1);
                
            }
            if(!stack.isEmpty()){
                left[i]=stack.get(stack.size()-1);
            }
            stack.add(arr[i]);
            
        }stack.clear();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]>stack.get(stack.size()-1)){
                stack.remove(stack.size()-1);
                
            }
            if(!stack.isEmpty()){
                right[i]=stack.get(stack.size()-1);
            }
            stack.add(arr[i]);
            
        }
        int res=0;

        for(int i=0;i<arr.length;i++){
            if(left[i]>0 && right[i]>0){
                res+=arr[i]*(Math.min(left[i],right[i]));
            }else if(left[i]>0 && right[i]==0){
                res+=arr[i]*left[i];
            }else if(left[i]==0 && right[i]>0){
                res+=arr[i]*right[i];
            }
            
        }
        
        return res;
        
    }
}