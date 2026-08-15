class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int total_XOR=0;
        boolean hasNonZero=false;
        for(int num:nums) {
            total_XOR^=num;
            if(num!=0) hasNonZero=true;
        }
        if(!hasNonZero) return 0;
        return (total_XOR==0) ? n-1 :n;
    }


}