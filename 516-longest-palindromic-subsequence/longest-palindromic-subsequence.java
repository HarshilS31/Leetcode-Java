class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        int[] dp1= new int[s.length()+1];
        int[] dp2= new int[s.length()+1];
        for(int i=1;i<=s.length();i++) {
            for(int j=1;j<=s2.length();j++) {
                if(s.charAt(i-1)==s2.charAt(j-1)) dp2[j]=1+dp1[j-1];
                else dp2[j]=Math.max(dp1[j],dp2[j-1]);

            }  
            int[] temp = dp1;
            dp1=dp2;
            dp2=temp;   
        }
        return dp1[s.length()];
    }
    
}