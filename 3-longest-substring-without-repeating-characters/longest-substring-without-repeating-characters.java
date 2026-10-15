class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0) return 0;
        if(n==1) return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0;
        int maxLen = Integer.MIN_VALUE;
        for(int right=0;right<n;right++) {
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1) {
                char c2 = s.charAt(left++);
                map.put(c2,map.getOrDefault(c2,0)-1);
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;        
    }
}