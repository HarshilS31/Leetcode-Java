class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int islands=0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(grid[i][j]=='1') {
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;

    }
    void dfs(int i,int j,char[][] grid) {
        grid[i][j]='2';//Visited
        int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d:directions) {
            int i1=i+d[0];
            int j1=j+d[1];
            if(i1>=0 && j1>=0 && i1<grid.length && j1<grid[0].length && grid[i1][j1]=='1') {
                dfs(i1,j1,grid);
            }
        }
    }
    
}