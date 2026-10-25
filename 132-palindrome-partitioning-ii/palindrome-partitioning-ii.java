class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; 
            } else {
                int minCuts = i; 
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        minCuts = Math.min(minCuts, dp[j - 1] + 1);
                    }
                }
                dp[i] = minCuts;
            }
        }
        return dp[n - 1];
    }
}