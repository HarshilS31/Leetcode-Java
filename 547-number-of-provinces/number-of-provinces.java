class Solution {
    public int findCircleNum(int[][] adj) {
        int count=0;
        int n=adj.length;
        int[] size= new int[n+1];
        int[] parent = new int[n+1]; 
        for(int i=1;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
        }
        parent[0]=Integer.MIN_VALUE;
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) { 
                if(adj[i][j]==1 && i!=j) {
                    union(i+1,j+1,parent,size);
                } 
            }
        }
        for(int i=1;i<=n;i++) {
            if(parent[i]==i) count++;
        }
        return count;
        
    }
    public void union(int x,int y,int[] parent,int[] size) {
        x=find(x,parent);
        y=find(y,parent);
        if (size[x]>=size[y]) {
            parent[y]=x;
            size[x]+=size[y];
        }     
        else if(size[y]>size[x]){
            parent[x]=y;
            size[y]+=size[x];
        }
  

    }
    public static int find(int node,int[] parent) {
        if(node==parent[node]) return node;
        return parent[node] = find(parent[node],parent);

    }
}
