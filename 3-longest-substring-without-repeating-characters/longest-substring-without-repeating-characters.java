class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        if(n<=1) return n;
        int maxLen=Integer.MIN_VALUE;
        int left=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0;right<n;right++) {
            char r=s.charAt(right);
            map.put(r,map.getOrDefault(r,0)+1);
            while(left < right && map.get(r)>1) {
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l,0)-1);
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}