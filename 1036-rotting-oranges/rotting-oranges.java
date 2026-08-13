class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int minTime=0;
        int freshOranges=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) q.add(new int[]{i,j,0});
                else if(grid[i][j]==1) freshOranges++;
            }
        }
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x=top[0];
            int y=top[1];
            int currTime=top[2];
            minTime=Math.max(minTime,currTime);
            int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] d:directions) {
                int x1=x+d[0];
                int y1= y+d[1];
                if( x1>=0 && y1>=0 && x1<m && y1<n && grid[x1][y1]==1) {
                    grid[x1][y1]=2;
                    freshOranges--;
                    q.add(new int[]{x1,y1,currTime+1});
                }
            }
        }
        return freshOranges==0 ? minTime :-1;
    }
}