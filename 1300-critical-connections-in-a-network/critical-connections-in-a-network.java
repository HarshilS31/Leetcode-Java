class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(List<Integer> conn:connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            adj[u].add(v);
            adj[v].add(u);    
        }
        int[] visited = new int[n];
        int[] insert_T = new int[n];
        int[] low_T = new int[n];
        List<List<Integer>>  bridges = new ArrayList<>();
        dfs(0,-1,adj,visited,insert_T,low_T,bridges);
        return bridges;
    
    }
    public void dfs(int node,int parent,List<Integer>[] adj,int[] visited,int[] insert_T,int[] low_T,List<List<Integer>> bridges) {
        visited[node]=1;
        insert_T[node]=low_T[node]=timer++;
        for(int adj_node:adj[node]) {
            if(adj_node==parent) continue;
            if(visited[adj_node]==0) {
                dfs(adj_node,node,adj,visited,insert_T,low_T,bridges);
                low_T[node]=Math.min(low_T[node],low_T[adj_node]);
                if(insert_T[node]<low_T[adj_node]) bridges.add(Arrays.asList(node,adj_node));
            }
            else {
                low_T[node]=Math.min(low_T[node],low_T[adj_node]);
            }
        }
    }
}