class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return LCS(text1,text2,m-1,n-1,dp);     
    }
    public int LCS(String s1,String s2,int i,int j,int[][] dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        char c1=s1.charAt(i);
        char c2=s2.charAt(j);
        if(c1==c2) return dp[i][j]=1+LCS(s1,s2,i-1,j-1,dp);
        return dp[i][j]=Math.max(LCS(s1,s2,i-1,j,dp),LCS(s1,s2,i,j-1,dp));
    }
}