class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char mn = s.charAt(0), mx = s.charAt(0);
        
        for (int i = 1; i < n; i++) {
            mn = (char) Math.min(mn, s.charAt(i));
            mx = (char) Math.max(mx, s.charAt(i));
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
            }
        }
        
        if (isSorted) return 0;
        if (n == 2) return -1;
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }
        return 3;
    }
}