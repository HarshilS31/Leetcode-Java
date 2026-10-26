class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int reqIslands=0;
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0 && visited[i][j]==0) {
                    long sum=dfs(grid,i,j,visited);
                    if(sum%k==0 && sum!=0) reqIslands++;
                }
            }
        }
        return reqIslands;
    }
    public long dfs(int[][] grid,int i,int j,int[][] visited) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==0) return 0;
        if(grid[i][j]==0) return 0;
        visited[i][j]=1;
        long currSum = grid[i][j];
        currSum+=dfs(grid,i+1,j,visited);
        currSum+=dfs(grid,i-1,j,visited);
        currSum+=dfs(grid,i,j+1,visited);
        currSum+=dfs(grid,i,j-1,visited);
        return currSum;
    }

}