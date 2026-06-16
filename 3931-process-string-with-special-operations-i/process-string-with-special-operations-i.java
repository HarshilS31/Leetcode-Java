class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(char c:s.toCharArray()) {
            if(c!='*' && c!='#' && c!='%') ans.append(c);
            else if(c=='*' && ans.length()>0) ans.deleteCharAt(ans.length()-1); 
            else if(c=='#') {
                StringBuilder duplicate = ans;
                ans.append(duplicate);
            }
            else if(c=='%') ans.reverse(); 
        }
        return ans.toString();
        
    }
}