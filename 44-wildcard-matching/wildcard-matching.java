class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return matchesOrNot(s, p, n - 1, m - 1, dp);
    }
    public boolean matchesOrNot(String s, String p, int i, int j, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) {
            for (int k = j; k >= 0; k--) if (p.charAt(k) != '*') return false;
            return true;
        }
        if (j < 0 && i >= 0) return false;
        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return dp[i][j] = matchesOrNot(s, p, i - 1, j - 1, dp);
        if (p.charAt(j) == '*') return dp[i][j] = matchesOrNot(s, p, i - 1, j, dp) || matchesOrNot(s, p, i, j - 1, dp);
        return dp[i][j] = false;
    }
}