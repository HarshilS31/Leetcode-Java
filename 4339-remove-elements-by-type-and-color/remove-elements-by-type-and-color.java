class Solution {
    static boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        int[] stT = new int[n], stC = new int[n], stCnt = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            int t = types[i], c = colors[i];
            if (top >= 0 && stT[top] == t && stC[top] == c) {
                stCnt[top]++;
            } else {
                top++;
                stT[top] = t;
                stC[top] = c;
                stCnt[top] = 1;
            }
    
            if (stCnt[top] == groupSize[t]) {
                top--; 
            }
        }
        return top == -1;
    }
}
