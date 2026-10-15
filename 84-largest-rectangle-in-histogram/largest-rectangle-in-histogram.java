class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,n);
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) s.pop();
            if(!s.isEmpty()) pse[i]=s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--) {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) s.pop();
            if(!s.isEmpty()) nse[i]=s.peek();
            s.push(i);
        }
        for(int i=0;i<n;i++) {
            int currArea = heights[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}