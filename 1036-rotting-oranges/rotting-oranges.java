class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j, 0});
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (q.size() > 0) {
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            int t = top[2];
            time = t > time ? t : time;

            for (int[] d : directions) {
                int x1 = x + d[0];
                int y1 = y + d[1];
                if (x1 >= 0 && y1 >= 0 && x1 < n && y1 < m && grid[x1][y1] == 1) {
                    grid[x1][y1] = 2;
                    fresh--;
                    q.add(new int[]{x1, y1, t + 1});
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}