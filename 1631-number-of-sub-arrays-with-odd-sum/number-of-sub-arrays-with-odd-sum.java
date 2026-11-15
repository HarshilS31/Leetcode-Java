class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int oddCount = 0;
        int evenCount = 1;
        int prefixSum = 0;
        int total = 0;
        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 1) {
                total = (total + evenCount) % MOD;
                oddCount++;
            } else {
                total = (total + oddCount) % MOD;
                evenCount++;
            }
        }
        return total;
    }
}