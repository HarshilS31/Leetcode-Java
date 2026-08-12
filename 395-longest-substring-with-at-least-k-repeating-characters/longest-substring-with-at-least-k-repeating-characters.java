class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int unique = 0, countAtLeastK = 0;
            while (right < n) {
                if (unique <= targetUnique) {
                    int idx = s.charAt(right) - 'a';
                    if (freq[idx] == 0) unique++;
                    freq[idx]++;
                    if (freq[idx] == k) countAtLeastK++;
                    right++;
                } else {
                    int idx = s.charAt(left) - 'a';
                    if (freq[idx] == k) countAtLeastK--;
                    freq[idx]--;
                    if (freq[idx] == 0) unique--;
                    left++;
                }
                if (unique == targetUnique && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}