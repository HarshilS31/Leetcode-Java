class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[][] res = new int[n][n];
        for(int[] arr : res) Arrays.fill(arr,Integer.MAX_VALUE);
        res[0][0]=1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            int d =top[2];
            for(int[] dir : directions) {
                int x1 = x+dir[0];
                int y1 = y+dir[1];
                if(x1>=0 && y1>=0 && x1<n && y1<n && grid[x1][y1]==0) {
                    if(res[x1][y1]>d+1) {
                        res[x1][y1]=d+1;
                        q.add(new int[]{x1,y1,d+1});
                    }
                }
            }
        }
        return res[n-1][n-1] == Integer.MAX_VALUE ? -1 :res[n-1][n-1];
    }
}