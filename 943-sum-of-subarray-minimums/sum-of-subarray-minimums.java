class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        long sum = 0;
        int[] stack = new int[n + 1];
        int top = -1;
        for (int i = 0; i <= n; i++) {
            while (top >= 0 && (i == n || arr[stack[top]] >= arr[i])) {
                int mid = stack[top--];
                int left = top < 0 ? -1 : stack[top];
                sum = (sum + (long) arr[mid] * (mid - left) * (i - mid)) % MOD;
            }
            stack[++top] = i;
        }
        return (int) sum;
    }
}