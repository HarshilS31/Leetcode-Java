class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first =findIndex(nums,target,true);
        if(first==-1) return new int[]{-1,-1};
        int last=findIndex(nums,target,false);
        return new int[]{first,last};

        
    }
    int findIndex(int[] arr,int target,boolean isFirst) {
        int lo=0; int hi=arr.length-1;
        int ans=-1;
        while(hi>=lo){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]==target){
                ans=mid;
                if(isFirst) hi=mid-1;
                else lo=mid+1;

            }
            else if(arr[mid]>target) hi=mid-1;
            else lo=mid+1;

        }
        return ans;
    }
}