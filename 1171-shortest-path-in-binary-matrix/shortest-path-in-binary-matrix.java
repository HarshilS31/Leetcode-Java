import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        dist[0][0] = 1;
        pq.offer(new int[]{1, 0, 0});
        int[][] directions = {{-1, -1},{-1, 0},{-1, 1},{1, -1},{1, 0},{1, 1},{0, -1},{0, 1}};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int r = current[1];
            int c = current[2];
            if (r == n - 1 && c == n - 1) {
                return d;
            }
            if (d > dist[r][c]) {
                continue;
            }
            
            // Explore all 8 directions
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[dir.length - 1]; 
                if (newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0) {
                    int nextDist = d + 1;
                    if (nextDist < dist[newR][newC]) {
                        dist[newR][newC] = nextDist;
                        pq.offer(new int[]{nextDist, newR, newC});
                    }
                }
            }
        }
        
        return -1;
    }
}