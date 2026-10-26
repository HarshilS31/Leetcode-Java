class Solution {
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int reqIslands=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]!=0 && !visited[i][j]) {
                    long sum=dfs(grid,i,j,visited);
                    if(sum%k==0 && sum!=0) reqIslands++;
                }
            }
        }
        return reqIslands;
    }
    public long dfs(int[][] grid,int i,int j,boolean[][] visited) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]==0) return 0;
        if(grid[i][j]==0) return 0;
        visited[i][j]=true;
        long currSum = grid[i][j];
        for(int[] d:directions) {
            int x = i+d[0];
            int y = j+d[1];
            currSum+=dfs(grid,x,y,visited);
            
        }
        return currSum;


    }

}