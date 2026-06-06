class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count=0;
        int left=0;
        for(int right=0;right<s.length();right++) {
            char c=s.charAt(right);
            freq[c-'a']++;
            while(all3(freq)) {
                count+=s.length()-right;
                freq[s.charAt(left++)-'a']--;
            }

        }
        return count;


        
    }
    boolean all3(int[] freq) {
        for(int f:freq) {
            if(f==0) return false;
        }
        return true;
    }
}