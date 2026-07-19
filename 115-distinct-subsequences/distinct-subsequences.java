class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return findWays(s,t,dp,n-1,m-1);
    }
    public int findWays(String s,String t,int[][] dp,int i,int j) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) {
            return dp[i][j]=findWays(s,t,dp,i-1,j-1)+findWays(s,t,dp,i-1,j);  
        }
        return dp[i][j]=findWays(s,t,dp,i-1,j);
    }
}