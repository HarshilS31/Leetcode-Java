class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        if(n==1) return new int[]{0};
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<n;i++) {
            while(!s.isEmpty() && temp[i]>temp[s.peek()]) {
                int idx = s.pop();
                res[idx]=i-idx;
            }
            s.push(i);
        }
        return res;
        
    }
}