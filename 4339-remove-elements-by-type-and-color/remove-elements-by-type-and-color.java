class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        Stack<int[]> s = new Stack<>();
        for(int i=0;i<n;i++) {
            int t = types[i];
            int c = colors[i];
            if(!s.isEmpty() && s.peek()[0]==t && s.peek()[1]==c) {
                s.peek()[2]++;
            }else {
                s.push(new int[]{t,c,1});
            }
            if(s.peek()[2]==groupSize[t]) {
                s.pop();
            }
        }
        return s.isEmpty();
    }
}