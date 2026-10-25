class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return minOps(word1,word2,m-1,n-1,dp);
    }
    public int minOps(String word1,String word2,int i,int j,int[][] dp) {
        if(i<0) return j+1;
        else if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        if(c1==c2) return dp[i][j]=minOps(word1,word2,i-1,j-1,dp);
        int replace = 1+minOps(word1,word2,i-1,j-1,dp);
        int delete = 1+minOps(word1,word2,i-1,j,dp);
        int insert = 1+minOps(word1,word2,i,j-1,dp);
        return dp[i][j]=Math.min(replace,Math.min(delete,insert));

    }
}