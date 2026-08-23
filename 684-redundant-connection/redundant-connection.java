class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!union(u, v, parent, rank)) {
                return edge;
            }
        }

        return new int[0];
    }
    public boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU == rootV) {
            return false;
        }
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
    }
    public int find(int node, int[] parent) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node], parent); 
    }
}