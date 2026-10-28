class Solution {
    public int maxProduct(int[] nums) {
        //Brute force
        int n = nums.length;
        int maxP=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int currP=1;
            for(int j=i;j<n;j++) {
                currP*=nums[j];
                maxP=Math.max(maxP,currP);
            }
        }
        return maxP;
    
    }
}