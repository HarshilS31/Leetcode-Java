class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        pse[0] = -1;
        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        nse[n-1] = n;
        
        for (int i = n-2; i >= 0; i--) {
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nse[i] = n; 
            } else {
                nse[i] = s.peek();
            }
            s.push(i);
        }
        while(!s.isEmpty()) s.pop();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while(!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = s.peek();
            }
            s.push(i);
        }
        int maxarea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxarea = Math.max(maxarea, area); 
        }
        
        return maxarea;
    }
}