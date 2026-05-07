class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans=new StringBuilder(strs[0]);
        StringBuilder curr=new StringBuilder();

        for(int i=1;i<strs.length;i++) {
            int len=Math.min(strs[i].length(),ans.length());
            StringBuilder s1=new StringBuilder(strs[i]);
            for(int j=0;j<len;j++) {
                if(s1.charAt(j)==ans.charAt(j)) curr.append(s1.charAt(j));
                else break;
            }
            

            ans.setLength(0);
            ans.append(curr);
            curr.setLength(0);

        }
        return ans.toString();

        
    }
}