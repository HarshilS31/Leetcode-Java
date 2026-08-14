class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] status =new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(isSafe(i,graph,status)) res.add(i);
        }
        return res; 
    }
    public boolean isSafe(int curr,int[][] graph,int[] status) {
        if(status[curr]!=0) return status[curr]==2;
        status[curr]=1;
        for(int node:graph[curr]) {
            if(!isSafe(node,graph,status)) return false;
        }
        status[curr]=2;
        return true;
    }
}