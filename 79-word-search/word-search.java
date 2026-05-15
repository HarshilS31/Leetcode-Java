class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean find(char[][] board, String word, int i, int j, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '$'; 
        for (int[] dir : directions) {
            int i1 = i + dir[0];
            int j1 = j + dir[1];
            if (find(board, word, i1, j1, idx + 1)) return true;
        }
        board[i][j] = temp;
        return false;
    }
}