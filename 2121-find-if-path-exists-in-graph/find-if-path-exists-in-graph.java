class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int[] arr: edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        visited[source]=true;
        bfs(source,visited,adj);
        return visited[destination];   
    }
    public void bfs(int source,boolean[] visited,List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            int top=q.poll();
            for(int edge : adj.get(top)) {
                if(!visited[edge]) {
                    visited[edge]=true;
                    q.add(edge);

                }
            }
        }
       
    }
}