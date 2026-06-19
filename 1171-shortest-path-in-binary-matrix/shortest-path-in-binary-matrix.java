class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        if(grid[0].length==1 && grid[0][0]==0) return 1; 
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(distance[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int[][] directions ={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        boolean[][] visited = new boolean[n][n];
        pq.add(new int[]{0,0,1});
        visited[0][0]=true;
        while(pq.size()>0) {
            int[] top = pq.poll();
            int x=top[0];
            int y=top[1];
            int d=top[2];
            
            for(int[] dir:directions) {
                int x1=x+dir[0];
                int y1=y+dir[1];
                
                if(x1>=0 && y1>=0 && x1<n && y1<n && grid[x1][y1]==0 && !visited[x1][y1]) {
                    int dist=d+1;
                    if(distance[x1][y1]>dist) {
                        distance[x1][y1]=dist;
                        pq.add(new int[]{x1,y1,dist});
                    }
                    visited[x1][y1]=true;
                    
                }
            }
        }
        return distance[n-1][n-1]== Integer.MAX_VALUE ? -1:distance[n-1][n-1];    
    }
}