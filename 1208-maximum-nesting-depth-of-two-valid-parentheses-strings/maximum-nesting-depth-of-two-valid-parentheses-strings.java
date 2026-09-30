class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depth = 0;
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                res[i] = depth % 2; 
            } else {
                res[i] = depth % 2;
                depth--;
            }
        }

        return res;
    }
}