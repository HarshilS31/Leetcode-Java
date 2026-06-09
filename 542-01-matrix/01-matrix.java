class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c =mat[0].length;
        int[][] ans = new int[r][c];
        for(int i=0;i<r;i++) Arrays.fill(ans[i],-1);
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(mat[i][j]==0 && ans[i][j]==-1) {
                    ans[i][j]=0;
                    q.add(new int[]{i,j});

                }
            }
        } 
        int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}}; 
        while(q.size()>0) {
            int[] front=q.remove();
            for(int[] d:directions) {
                int i1=front[0]+d[0];
                int j1=front[1]+d[1];
                if (i1 >= 0 && j1 >= 0 && i1 < r && j1 < c && mat[i1][j1] == 1 && ans[i1][j1] == -1) {
                    ans[i1][j1]=ans[front[0]][front[1]]+1;  
                    q.add(new int[]{i1,j1});  

                }
            }
        

        }  
        return  ans;    
    }
}