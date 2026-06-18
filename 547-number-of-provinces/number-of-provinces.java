class Solution {
    public int findCircleNum(int[][] adj) {
        int count=0;
        int n=adj.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(adj,visited,i);
                count++;
            }
        }
        return count;
    }
    void dfs(int[][] adj,boolean[] visited,int idx) {
        int n=adj.length;
        visited[idx]=true;
        for(int j=0;j<n;j++) {
            if(adj[idx][j]==1 && !visited[j]) {
                dfs(adj,visited,j);
            }
        }


    }
}