class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && visited[i][j]==0) {
                    bfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int i,int j,int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new int[]{i,j});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x=top[0];
            int y=top[1];
            for(int[] d:directions) {
                int x1=x+d[0];
                int y1=y+d[1];
                if(x1>=0 && y1>=0 && x1<grid.length && y1<grid[0].length && grid[x1][y1]=='1' && visited[x1][y1]==0) {
                    q.add(new int[]{x1,y1});
                    visited[x1][y1]=1;
                }
            }
        }

    }
}