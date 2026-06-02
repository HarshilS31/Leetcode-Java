class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree =new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++) {
            for(int node:graph[i]) {
                adj.get(node).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++) {
            if(inDegree[i]==0) q.add(i);
        }
        while(q.size()>0) {
            int front = q.remove();
            ans.add(front);
            for(int node:adj.get(front)) {
                inDegree[node]--;
                if(inDegree[node]==0) {
                    q.add(node);

                }
            }
        } 
        Collections.sort(ans);
        return ans;


        
        

        


        
    }
}