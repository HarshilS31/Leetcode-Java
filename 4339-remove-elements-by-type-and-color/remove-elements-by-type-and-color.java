class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int n = types.length;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            int t = types[i];
            int c = colors[i];
            if(!stack.isEmpty() && stack.peek()[0]==t && stack.peek()[1]==c) {
                stack.peek()[2]++;
            }
            else {
                stack.push(new int[]{t,c,1});
            }
            if(stack.peek()[2]==groupSize[t]) {
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}