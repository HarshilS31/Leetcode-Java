class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i=0; i<n;i++) {
            dp[i][0]=1;
        }
        for (int i =0;i<n;i++) {
            for (int j =1; j<=amount;j++) {
                if (i==0) {
                    dp[i][j]=(j %coins[i]==0) ?1:0;
                } else {
                    int skip=dp[i-1][j];
                    int pick=(j>=coins[i]) ?dp[i][j-coins[i]]:0;
                    dp[i][j]=skip+pick;
                }
            }
        }
        return dp[n-1][amount];
    }
}