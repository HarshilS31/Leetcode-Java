class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long minCost = Long.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != nums[left]) {
                left = right;
            }
            if (right > 0 && left < n - 1) {
                long prefixCost = (long) left * nums[left];
                long suffixCost = (long) (n - 1 - right) * nums[right];
                minCost = Math.min(minCost, prefixCost + suffixCost);
            }
        }

        return minCost;
    }
}