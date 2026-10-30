class Solution {
    int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j]=='1' && visited[i][j]==0) {
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int i,int j,int[][] visited) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==1) return;
        visited[i][j]=1;
        for(int[] d:directions) {
            dfs(grid,i+d[0],j+d[1],visited);
        }
    }
}