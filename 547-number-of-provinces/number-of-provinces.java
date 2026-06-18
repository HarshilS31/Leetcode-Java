class Solution {
    public int findCircleNum(int[][] adj) {
        int count=0;
        int n=adj.length;
        int[] parent = new int[n+1]; 
        for(int i=1;i<=n;i++) parent[i]=i;
        parent[0]=Integer.MIN_VALUE;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) { 
                if(adj[i][j]==1 && i!=j) {
                    union(i+1,j+1,parent);
                } 
            }
        }
        for(int i=1;i<=n;i++) {
            if(parent[i]==i) count++;
        }
        return count;
        
    }
    public void union(int x,int y,int[] parent) {
        int ultimateP_x=find(x,parent);
        int ultimateP_y=find(y,parent);
        if(ultimateP_x!=ultimateP_y) {
            parent[ultimateP_y]=ultimateP_x;

        }

    }
    public static int find(int node,int[] parent) {
        if(node==parent[node]) return node;
        return find(parent[node],parent);

    }
}
