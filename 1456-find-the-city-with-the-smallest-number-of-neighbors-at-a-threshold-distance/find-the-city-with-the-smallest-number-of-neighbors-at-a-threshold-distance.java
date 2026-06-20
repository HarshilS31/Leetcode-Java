class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e7;
        int[][] sd = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sd[i][j] = 0;
                } else {
                    sd[i][j] = INF;
                }
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            sd[u][v] = w;
            sd[v][u] = w;
        }
        for (int v = 0; v < n; v++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sd[i][j] = Math.min(sd[i][j], sd[i][v] + sd[v][j]);
                }
            }
        }
        int connectedCities = n;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int citiesConnected = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && sd[i][j] <= distanceThreshold) {
                    citiesConnected++;
                }
            }

            if (citiesConnected <= connectedCities) {
                connectedCities = citiesConnected;
                city = i;
            }
        }
        return city;
    }
}