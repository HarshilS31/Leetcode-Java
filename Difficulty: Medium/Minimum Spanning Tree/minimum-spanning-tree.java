class Solution {
    public int spanningTree(int V, int[][] edges) {
        int sum = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        // Storing {node, weight} to match your unpacking logic: top[0]->node, top[1]->w
        pq.offer(new int[]{0, 0}); 
        while (pq.size() > 0) {
            int[] top = pq.poll();
            int node = top[0];
            int w = top[1];
            if (visited[node]) continue;
            visited[node] = true;
            // WE MARK A node visited only when we add it to the MST
            // not when we add it in the PRIORITY Queue!
            sum += w;
            // and add the array [node,parent] in the MST(not in this Question)
            for (int[] arr : adj.get(node)) {
                int adjNode = arr[0];
                int edgeW = arr[1];
                if (!visited[adjNode]) {
                    pq.add(new int[]{adjNode, edgeW});
                }
            }
        }
        return sum;
    }
}
