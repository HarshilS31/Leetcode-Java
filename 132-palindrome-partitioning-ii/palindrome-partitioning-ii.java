class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,dp)-1;
    }
    public int solve(String s,int i,int[] dp) {
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++) {
            if(isPalindrome(s,i,j)) {
                int cost = 1+solve(s,j+1,dp);
                minCost=Math.min(minCost,cost);
            }
        }
        return dp[i]=minCost;
    }
    public boolean isPalindrome(String s,int i,int j) {
        while(i<j) {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}