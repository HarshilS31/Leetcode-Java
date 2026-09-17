class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int left = 0, currentSum = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            while (currentSum > target && left <= right) {
                currentSum -= arr[left++];
            }
            if (currentSum == target) {
                int currentLen = right - left + 1;
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, best[left - 1] + currentLen);
                }
                minLen = Math.min(minLen, currentLen);
            }
            best[right] = minLen;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}