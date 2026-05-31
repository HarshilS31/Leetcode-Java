class Solution {
    public boolean canFinish(int n, int[][] preR) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited=new boolean[n];
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge:preR) {
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(inDegree[i]==0) {
            q.add(i);
            visited[i]=true;
            }
        }
        while(q.size()>0) {
            int front = q.remove();
            ans.add(front);
            for(int node:adj.get(front)) {
                inDegree[node]--;
                if(inDegree[node]==0) {
                    q.add(node);
                    visited[node]=true;

                }

            
            }
        }
        if(ans.size()==n) return true;
        return false;

        
        
    }
}