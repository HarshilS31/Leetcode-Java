class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++) {
                if(board[i][j]!='.') {
                    if((isValid(board,board[i][j],i,j))==true) continue;
                    else return false;
                }
            }
        }
        return true;    
    }

    boolean isValid(char[][] board,char ch,int i,int j) {
        int rowCount=0;
        int colCount=0;
        int boxCount=0;
        for(int k=0;k<9;k++) {
            if(board[i][k]==ch) rowCount++;
            if(board[k][j]==ch) colCount++;
            if(rowCount>1 || colCount>1) return false;
        }
        int box_i=(i/3)*3;
        int box_j=(j/3)*3;
        for(int k=box_i;k<box_i+3;k++) {
            for(int l=box_j;l<box_j+3;l++){
                if(board[k][l]==ch) boxCount++;
                if(boxCount>1) return false;
            }
        }
        return true;
    }
}