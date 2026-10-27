class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        Boolean[] dp = new Boolean[n];
        Set<String> set = new HashSet<>();
        for(String str:wordDict) set.add(str);
        return solve(s,set,0,n,dp);    
    }
    public boolean solve(String s,Set<String> set,int i,int n,Boolean[] dp) {
        if(i==n) return true;
        if(dp[i]!=null) return dp[i];
        for(int j=i+1;j<=n;j++) {
            if(set.contains(s.substring(i,j)) && solve(s,set,j,n,dp)) return dp[i]=true;
        }
        return dp[i]=false;

    }
}