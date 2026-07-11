class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<pre.length;i++) {
            int x = pre[i][0];
            int y = pre[i][1];
            adj.get(y).add(x);
            indegree[x]++;
        }
        for(int i=0;i<n;i++)  {
            if(indegree[i]==0) {
                q.add(i);
                visited[i]=true;
            }
        }
        while(q.size()>0) {
            int top = q.poll();
            ans.add(top);
            for(int node : adj.get(top)) {
                indegree[node]--;
                if(indegree[node]==0) {
                    q.add(node);
                    visited[node]=true; 
                }
                
            }
            
        }
        return ans.size()==n;
        
    }
}