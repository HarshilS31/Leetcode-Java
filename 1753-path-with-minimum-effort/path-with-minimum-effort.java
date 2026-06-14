class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int[][] ans = new int[m][n];
        for(int[] arr:ans) Arrays.fill(arr,Integer.MAX_VALUE);
        ans[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        while(pq.size()>0) {
            int[] top=pq.poll();
            int diff=top[0];
            int x=top[1];
            int y=top[2];
            for(int[] d:directions) {
                int x1=x+d[0];
                int y1=y+d[1];
                if(x1>=0 && y1>=0 && x1<m && y1<n) {
                    int absDiff=Math.abs(heights[x][y]-heights[x1][y1]);
                    int maxDiff=Math.max(diff,absDiff);
                    if(ans[x1][y1]>maxDiff) {
                        ans[x1][y1]=maxDiff;
                        pq.offer(new int[]{maxDiff,x1,y1});
                    }
                }
            }
        }
        return ans[m-1][n-1];
    }
}