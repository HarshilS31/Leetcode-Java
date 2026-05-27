class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] visited =new boolean[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(!visited[i][j] && grid[i][j]=='1') {
                    dfs(grid,visited,i,j);
                    islands++;
                    
                }
            }
        } 
        return islands;  
    }
    void dfs(char[][] grid, boolean[][] visited, int i, int j)  {
        visited[i][j]=true;
        if(i-1>=0 && !visited[i-1][j]  && grid[i-1][j]=='1' ) dfs(grid,visited,i-1,j);
        if(j-1>=0 && !visited[i][j-1]  && grid[i][j-1]=='1' ) dfs(grid,visited,i,j-1);
        if(i+1<grid.length && !visited[i+1][j] &&  grid[i+1][j]=='1' ) dfs(grid,visited,i+1,j);
        if(j+1<grid[0].length && !visited[i][j+1]  && grid[i][j+1]=='1' ) dfs(grid,visited,i,j+1);





    }
     

}