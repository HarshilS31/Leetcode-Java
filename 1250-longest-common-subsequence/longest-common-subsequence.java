class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return lcs(dp.length-1,dp[0].length-1,text1,text2,dp);
    }
    public int lcs(int i,int j,String text1,String text2,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)) return dp[i][j]=1+lcs(i-1,j-1,text1,text2,dp);
        return dp[i][j]=Math.max(lcs(i-1,j,text1,text2,dp),lcs(i,j-1,text1,text2,dp));
    }
}