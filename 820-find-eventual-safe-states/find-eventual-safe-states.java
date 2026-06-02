class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] status=new int[graph.length];
        // 0->unvisited, 1->visiting, 2->safe
        for(int i=0;i<graph.length;i++) {
            if(isSafe(i,graph,status)) ans.add(i);
        }
        return ans;
    }
    public boolean isSafe(int currNode,int[][] graph,int[] status) {
        if(status[currNode]!=0) return status[currNode]==2;
        status[currNode]=1;
        for(int node:graph[currNode]) {
            if(!isSafe(node,graph,status)) return false;
        }
        status[currNode]=2;
        return true;

 
    }
}