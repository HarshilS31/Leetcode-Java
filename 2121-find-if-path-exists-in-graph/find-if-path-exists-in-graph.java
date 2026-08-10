class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        boolean[] visited =  new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i=0;i<edges.length;i++) {
            int a =edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfs(source,visited,adj);
        return visited[destination];     
    }
    
    void bfs(int source,boolean[] visited,List<List<Integer>> adj) {
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        while(q.size()>0) {
            int front=q.remove();
            for(int ele:adj.get(front)) {
                if(!visited[ele]) {
                    visited[ele]=true;
                    q.add(ele);

                }
            }
        }
    }
}