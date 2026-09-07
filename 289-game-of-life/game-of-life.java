class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<int[]> changeState = new ArrayList<int[]>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                updateState(board,i,j,changeState);
            }
        }
        for(int[] state:changeState) {
            int x = state[0];
            int y = state[1];
            board[x][y]=1-board[x][y];
        }   
    }

    public void updateState(int[][] board,int r,int c,List<int[]> changeState) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions  = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int neighbours = 0;
        for(int[] d:directions) {
            int x = r + d[0];
            int y = c + d[1];
            if(x>=0 && y>=0 && x<m && y<n && board[x][y]==1) neighbours++;
        }
        if(board[r][c]==1 && neighbours<2) changeState.add(new int[]{r,c});
        else if(board[r][c]==1 && neighbours>3) changeState.add(new int[]{r,c});
        else if(board[r][c]==0 && neighbours==3) changeState.add(new int[]{r,c});

    }
}