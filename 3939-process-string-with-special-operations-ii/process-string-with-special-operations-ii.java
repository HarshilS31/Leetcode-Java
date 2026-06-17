class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        lengths[0] = 0; 
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                lengths[i + 1] = Math.max(0, lengths[i] - 1);
            } else if (c == '#') {
                lengths[i + 1] = lengths[i] * 2;
            } else if (c == '%') {
                lengths[i + 1] = lengths[i];
            } else {
                lengths[i + 1] = lengths[i] + 1;
            }
        }
        if (k >= lengths[n]) {
            return '.';
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '*') {
                continue;
            } else if (c == '#') {
                long halfLength = lengths[i];
                if (k >= halfLength) {
                    k %= halfLength;
                }
            } else if (c == '%') {
                long currentLength = lengths[i];
                k = currentLength - 1 - k;
            } else {
                if (k == lengths[i + 1] - 1) {
                    return c;
                }
            }
        }

        return '.';
    }
}