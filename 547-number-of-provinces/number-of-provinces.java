class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        parent[0]=Integer.MIN_VALUE;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<isConnected[i].length;j++) {
                if(isConnected[i][j]==1 && i!=j) findUnion(i+1,j+1,parent); 
            }
        }
        int count =0;
        for(int i=1;i<=n;i++) if(parent[i]==i) count++;
        return count;
    }
    public void findUnion(int x,int y,int[] parent) {
        int parent_Ux = find(x,parent);
        int parent_Uy = find(y,parent);
        if(parent_Ux!=parent_Uy) parent[parent_Uy]=parent[parent_Ux];
    }
    public int find(int i,int[] parent) {
        if(parent[i]==i) return i;
        return find(parent[i],parent);
    }
}