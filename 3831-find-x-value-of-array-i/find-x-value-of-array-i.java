class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        int[] prev =new int[k];
        for(int i=0;i<n;i++) {
            int[] curr = new int[k];
            int val = nums[i]%k;
            for(int r=0;r<k;r++) {
                if(prev[r]>0) {
                    int newR = (r*val)%k;
                    curr[newR]+=prev[r];
                }
            }
            curr[val]++;
            for(int r=0;r<k;r++) {
                res[r]+=curr[r];
            }
            prev=curr;  
        } 
        return res;

    }
    
}