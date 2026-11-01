class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum=0;
        int min = Integer.MAX_VALUE;
        for(int num:nums) {
            sum+=num;
            min=Math.min(min,num);
        }
        return sum-min*n;
 
        
    }
}