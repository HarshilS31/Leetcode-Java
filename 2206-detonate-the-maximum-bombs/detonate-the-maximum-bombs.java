class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long dx = (long) bombs[i][0] - bombs[j][0];
                long dy = (long) bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];
                if (dx * dx + dy * dy <= r * r) {
                    adj[i].add(j);
                }
            }
        }
        int maxBombs = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxBombs = Math.max(maxBombs, dfs(adj, visited, i));
        }
        return maxBombs;
    }
    private int dfs(List<Integer>[] adj, boolean[] visited, int curr) {
        visited[curr] = true;
        int count = 1;
        for (int neighbor : adj[curr]) {
            if (!visited[neighbor]) {
                count += dfs(adj, visited, neighbor);
            }
        }
        return count;
    }
}