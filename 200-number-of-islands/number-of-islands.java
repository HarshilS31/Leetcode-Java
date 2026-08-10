class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int islands=0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(grid[i][j]=='1') {
                    dfs(grid,i,j);
                    islands++;
                    
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid,int i,int j) {
        grid[i][j]='2'; //VISITED
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir :directions) {
            int i1=i+dir[0];
            int j1=j+dir[1];
            if(i1>=0 && j1>=0 &&  i1<grid.length && j1<grid[0].length && grid[i1][j1]=='1') {
                dfs(grid,i1,j1);
            }
        }
    }
}