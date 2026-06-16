class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if (word.charAt(0)==board[i][j] && search(board,word,0,i,j)) return true;
            }
        }
        return false;
        
    }
    boolean search(char[][] board,String word,int idx,int i,int j) {
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$' || board[i][j]!=word.charAt(idx)) return false;
        char temp=board[i][j];
        board[i][j]='$';
        for(int[] d:directions) {
            int i1=i+d[0];
            int j1=j+d[1];
            if(search(board,word,idx+1,i1,j1)) return true;
        }
        board[i][j]=temp;
        return false;
    }
    

    
}