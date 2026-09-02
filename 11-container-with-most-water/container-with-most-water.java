class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = (n-1)*Math.min(height[0],height[n-1]);
        int l=0;
        int r=n-1;
        while(l<r) {
            int currHeight=Math.min(height[l],height[r]);
            maxWater = Math.max(maxWater,(r-l)*currHeight);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxWater;
    }
}