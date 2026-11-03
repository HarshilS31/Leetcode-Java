class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums) {
            max=Math.max(num,max);
            sum+=num;
        }
        int moves = 0;
        return Math.abs(sum-(max*n));
        

        
    }
}