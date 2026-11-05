class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        int[] parent = new int[n+1];
        int[] size = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
        for(int[] e:edges) {
            if(!union(e[0],e[1],parent,size)) {
                res[0]=e[0];
                res[1]=e[1];
            }
        }
        return res;

    }
    public boolean union(int u, int v, int[] parent,int[] size) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU == rootV) {
            return false;
        }
        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
        } else if (size[rootU] > size[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            size[rootU]++;
        }
        return true;
    }
    public int find(int node, int[] parent) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent[node], parent); 
    }
}