class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        boolean[] redundant = new boolean[1]; 
        
        for (int[] edge : edges) {
            redundant[0] = false;
            union(edge[0], edge[1], parent, size, redundant); 
            if (redundant[0]) ans = edge;
        }
        
        return ans;
    }
    void union(int x, int y, int[] parent, int[] size, boolean[] redundant) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) redundant[0] = true;
        if (size[py] > size[px]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    int find(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node], parent);
    }
}