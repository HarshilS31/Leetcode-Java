class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);   
    }

    boolean solve(char[][] board) {
        for(int i =0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {
                    for(int k=0;k<9;k++) {
                        char c=(char)(k+'1');
                        if(isValid(board,i,j,c)) {
                            board[i][j]=c;
                            if(solve(board)) return true;
                            
                        }
                        board[i][j]='.';  
                    }
                    return false;
                }
                
            }
        }
        return true;

    }
    boolean isValid(char[][] board,int i,int j,char ch) {
        for(int t=0;t<9;t++) {
            if(board[i][t]==ch) return false;
            if(board[t][j]==ch) return false;
        }
        int box_i=(i/3)*3;
        int box_j=(j/3)*3;
        for(int r=box_i;r<box_i+3;r++) {
            for(int c=box_j;c<box_j+3;c++){
                if(board[r][c]==ch) return false;
            }
        }
        return true;

    }

}