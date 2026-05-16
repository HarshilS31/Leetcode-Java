class Solution {
    int[][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if( word.charAt(0)==board[i][j] && findWord(board,i,j,word,0)) {
                    return true;
                }
            }
        }
        return false;

        
    }
    boolean findWord(char[][] board,int i,int j,String word,int idx) {
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$' || word.charAt(idx)!=board[i][j]) return false;
        char temp=board[i][j];
        board[i][j]='$';
        for(int[] d:directions) {
            int i1=i+d[0];
            int j1=j+d[1];
            if(findWord(board,i1,j1,word,idx+1)) return true;    
        }
        board[i][j]=temp;
        return false;


    }
}