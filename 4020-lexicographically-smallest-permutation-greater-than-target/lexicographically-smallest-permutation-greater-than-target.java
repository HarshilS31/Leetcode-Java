class Solution {
    StringBuilder res = new StringBuilder();
    public String lexGreaterPermutation(String s, String target) {
        int n = target.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++) freq[s.charAt(i)-'a']++;
        StringBuilder curr = new StringBuilder();
        boolean isValid = findString(s,target,0,freq,curr,false);
        return isValid ? res.toString() : "";
    }
    public boolean findString(String s,String target,int i,int[] freq,StringBuilder curr,boolean isGreater) {
        if(i==target.length()) {
            if(isGreater) {
                res = curr;
                return true;
            }
            return false;
        }
        for(char c = 'a';c<='z';c++) {
            if(freq[c-'a']==0) continue;
            if(isGreater == false && c<target.charAt(i)) continue;
            curr.append(c);
            freq[c-'a']--;
            boolean stillGreater = isGreater || target.charAt(i)<c;
            if(findString(s,target,i+1,freq,curr,stillGreater)) return true;
            curr.deleteCharAt(curr.length()-1);
            freq[c-'a']++;
        }
        return false;
    }
    
}