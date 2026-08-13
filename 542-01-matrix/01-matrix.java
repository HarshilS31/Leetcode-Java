class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(res[i],-1);
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==0 && res[i][j]==-1) {
                    res[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int x=top[0];
            int y=top[1];
            for(int[] d:directions) {
                int x1=x+d[0];
                int y1=y+d[1];
                if(x1>=0 && y1>=0 && x1<m && y1<n && mat[x1][y1]==1 && res[x1][y1]==-1) {
                    res[x1][y1]=res[x][y]+1;
                    q.add(new int[]{x1,y1});
                }
            }
        }
        return res; 
    }
}