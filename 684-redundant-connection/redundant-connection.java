class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] edge:edges) {
            int u=edge[0],v=edge[1];
            if(union(u,v,parent,rank)) {
                res[0]=u;
                res[1]=v;
            }
        }
        return res;
    }
    public boolean union(int u,int v,int[] parent,int[] rank) {
        int pU = findP(u,parent);
        int pV = findP(v,parent);
        if(pU!=pV) {
            if(rank[pU]>rank[pV]) {
                parent[pV]=pU;
            }
            else if(rank[pU]<rank[pV]) {
                parent[pU]=pV;
            }
            else {
                parent[pV]=pU;
                rank[pU]++;

            }
            return false;
        }
        else return true;
    }
    public int findP(int node,int[] parent) {
        if(parent[node]==node) return node;
        return parent[node]= findP(parent[node],parent);
    }
}