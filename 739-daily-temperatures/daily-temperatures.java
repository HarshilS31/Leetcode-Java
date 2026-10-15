class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<n;i++) {
            while(!s.isEmpty() && temps[i]>temps[s.peek()]) {
                int idx = s.pop();
                res[idx]=i-idx;
            }
            s.push(i);
        }
        return res;
    }
}