class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if( i==0 || j==0 || i==m-1 || j==n-1 ) {
                    if(board[i][j]=='O') dfs(board,i,j);
                }
            }
        } 
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='O') board[i][j]='X'; 
                else if(board[i][j]=='$') board[i][j]='O';

            }
        } 
    }
    public void dfs(char[][] board,int x,int y) {
        board[x][y]='$';
        for(int[] d:directions) {
            int x1=x+d[0];
            int y1=y+d[1];
            if(x1>=0 && y1>=0 && x1<board.length && y1<board[0].length && board[x1][y1]=='O') {
                dfs(board,x1,y1);
            }
        }   
    }
}