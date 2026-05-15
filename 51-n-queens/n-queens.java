class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        nQueens(ans, board, 0, n);
        return ans;
    }

    void nQueens(List<List<String>> ans, List<String> board, int r, int n) {
        if (r == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPlace(board, r, j, n)) {
                char[] rowArr = board.get(r).toCharArray();
                rowArr[j] = 'Q';
                board.set(r, new String(rowArr));

                nQueens(ans, board, r + 1, n);

                rowArr[j] = '.';
                board.set(r, new String(rowArr));
            }
        }
    }

    boolean canPlace(List<String> board, int r, int c, int n) {
        for (int i = 0; i < r; i++) {
            if (board.get(i).charAt(c) == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}