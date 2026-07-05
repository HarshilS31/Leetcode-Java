class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time=0;
        int m=grid.length;
        int n =grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) q.add(new int[]{i,j,0});
                else if(grid[i][j]==1) fresh++;
            }
        }
        int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x=top[0];
            int y=top[1];
            int t=top[2];
            time=Math.max(t,time);
            for(int[] dir : directions) {
                int x1=x+dir[0];
                int y1=y+dir[1];
                if(x1>=0 && y1>=0 && x1<m && y1<n && grid[x1][y1]==1) {
                    grid[x1][y1]=2;
                    fresh--;
                    q.add(new int[]{x1,y1,t+1});

                }
            }

        }
        return fresh==0 ? time :-1;      
    }
}