class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        return solve(s, p, m, n, dp);
    }

    private boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (j == 0) return i == 0;
        if (i == 0) {
            if (p.charAt(j - 1) == '*') {
                return solve(s, p, i, j - 2, dp);
            }
            return false;
        }

        if (dp[i][j] != null) return dp[i][j];
        char c1 = s.charAt(i - 1);
        char c2 = p.charAt(j - 1);
        if (c1 == c2 || c2 == '.') {
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        }

        if (c2 == '*') {
            char pPrev = p.charAt(j - 2);
            boolean ignore = solve(s, p, i, j - 2, dp);
            boolean match = (c1 == pPrev || pPrev == '.') && solve(s, p, i - 1, j, dp);

            return dp[i][j] = ignore || match;
        }

        return dp[i][j] = false;
    }
}