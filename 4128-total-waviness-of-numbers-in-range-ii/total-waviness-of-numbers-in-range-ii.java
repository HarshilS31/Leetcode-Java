class Solution {
    Map<String, long[]> map;
    public long totalWaviness(long num1, long num2) {

        return getWaves(num2) - getWaves(num1 - 1);
    }

    long getWaves(long num) {
        map = new HashMap<>();
        String s = Long.toString(num);
        if (s.length() < 3) return 0;

        long[] ans = helper(s, 0, true, -1, -1, true);
        return ans[1];
    }


    long[] helper(String s, int idx, boolean isBound,
                  int twobefore, int onebefore, boolean leadingZero) {

        if (idx == s.length()) {

            return leadingZero ? new long[]{0, 0} : new long[]{1, 0};
        }

        String key = idx + "#" + isBound + "#" + twobefore + "#" + onebefore + "#" + leadingZero;
        if (map.containsKey(key)) return map.get(key);

        int upper = isBound ? (s.charAt(idx) - '0') : 9;
        long totalCount = 0L, totalWaves = 0L;

        for (int i = 0; i <= upper; i++) {
            long wave = 0;
            int nextTwoBefore, nextOneBefore;

            if (leadingZero) {

                nextTwoBefore = -1;
                nextOneBefore = (i == 0) ? -1 : i;
            } else {
                nextTwoBefore = onebefore;
                nextOneBefore = i;
                if (twobefore >= 0 && onebefore >= 0) {
                    if ((onebefore > twobefore && onebefore > i)   
                    ||  (onebefore < twobefore && onebefore < i))  
                        wave = 1;
                }
            }

            boolean nextBound = isBound && (i == upper);
            boolean nextLeadingZero = leadingZero && (i == 0);

            long[] sub = helper(s, idx + 1, nextBound, nextTwoBefore, nextOneBefore, nextLeadingZero);

            totalCount += sub[0];

            totalWaves += sub[1] + sub[0] * wave;
        }

        long[] result = {totalCount, totalWaves};
        map.put(key, result);
        return result;
    }
}