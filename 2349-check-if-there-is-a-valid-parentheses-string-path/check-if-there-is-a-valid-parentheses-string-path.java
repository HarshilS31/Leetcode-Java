class Solution {
    Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')') return false;

        int maxOpen = (m + n) / 2;
        memo = new Boolean[m][n][maxOpen + 1];

        return solve(grid, 0, 0, 0);
    }

    public boolean solve(char[][] grid, int validP, int i, int j) {
        // 1. Boundary Check
        if (i >= grid.length || j >= grid[0].length) {
            return false;
        }

        // 2. Process current cell
        validP += (grid[i][j] == '(') ? 1 : -1;

        // 3. Early Pruning (out of valid bounds)
        int maxOpen = (grid.length + grid[0].length) / 2;
        if (validP < 0 || validP > maxOpen) {
            return false;
        }

        // 4. Base Case: Reached Destination
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return validP == 0;
        }

        // 5. Memoization Lookup
        if (memo[i][j][validP] != null) {
            return memo[i][j][validP];
        }

        // 6. Recurse Right & Down
        boolean res = solve(grid, validP, i + 1, j) || solve(grid, validP, i, j + 1);

        return memo[i][j][validP] = res;
    }
}