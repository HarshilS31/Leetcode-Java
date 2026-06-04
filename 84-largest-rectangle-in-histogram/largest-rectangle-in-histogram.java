class Solution {
    // static{
    //     for(int i=0;i<1000;i++){
    //         largestRectangleArea(new int[] {i});
    //     }
    // }
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] stack=new int[n+1];
        int maxarea=0;
        int top=-1;
        for(int i=0;i<=n;i++){
            int currheight=(i==n)?0:heights[i];
            while(top!=-1 && currheight<heights[stack[top]]){
                int idx=stack[top--];
                int height=heights[idx];
                int width=(top==-1)?i:i-stack[top]-1;
                maxarea=Math.max(maxarea,height*width);
            }
            stack[++top]=i;
        }
        return maxarea;
    }
}