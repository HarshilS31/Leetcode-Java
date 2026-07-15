

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        // dp[index][remainingLength]
        int[][] dp = new int[n][n + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Start from the largest possible cut (length N, which is at index N-1)
        return maxPrice(n - 1, n, price, dp);
    }

    private int maxPrice(int index, int remainingLength, int[] price, int[][] dp) {
        // Base case: Only cuts of length 1 are left to consider
        if (index == 0) {
            return remainingLength * price[0];
        }

        if (dp[index][remainingLength] != -1) {
            return dp[index][remainingLength];
        }

        // Option 1: Skip this cut length
        int skip = maxPrice(index - 1, remainingLength, price, dp);

        // Option 2: Pick this cut length (if it fits)
        int pick = Integer.MIN_VALUE;
        int cutLength = index + 1; 
        
        if (cutLength <= remainingLength) {
            // Notice we pass 'index', NOT 'index - 1' (Unbounded Knapsack)
            pick = price[index] + maxPrice(index, remainingLength - cutLength, price, dp);
        }

        // Memoize and return the max of both choices
        return dp[index][remainingLength] = Math.max(skip, pick);
    }
}