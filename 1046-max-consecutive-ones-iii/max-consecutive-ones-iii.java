class Solution {
    public int longestOnes(int[] nums, int k) {
        //Brute Force!
        
        int maxLen=0;
        for(int i=0;i<nums.length;i++) {
            int zeroes=0;
            for(int j=i;j<nums.length;j++) {
                if(nums[j]==0) zeroes++;
                if (zeroes<=k) {
                    maxLen = (j-i+1)>maxLen ?(j-i+1):maxLen;
                }
                else break;
            }
        }
        return maxLen;

        
    }
}