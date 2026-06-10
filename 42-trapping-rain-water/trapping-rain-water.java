
class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int[] preMax=new int[n];
        int[] postMax=new int[n];
        preMax[0]=height[0];
        for(int i=1;i<n;i++) {
            preMax[i]=Math.max(preMax[i-1],height[i]);

        }
        postMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--) {
            postMax[i]=Math.max(height[i],postMax[i+1]);
        }
        int area=0;
        for(int i=0;i<n;i++) {
            if(height[i]==postMax[i] || height[i]==preMax[i]) continue;
            else {
                area+=Math.min(postMax[i],preMax[i])-height[i];
            }

        }
        return area;
        
   }
}