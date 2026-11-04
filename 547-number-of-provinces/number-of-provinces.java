class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int count = 0;
        int[] visited = new int[n];
        for(int i=0;i<n;i++) {
            if(visited[i]==0) {
                dfs(arr,i,visited);
                count++;
            }

        }
        return count;   
    }
    public void dfs(int[][] arr,int i,int[] visited) {
        visited[i]=1;
        for(int idx=0;idx<arr.length;idx++) {
            if(arr[i][idx]==1 && visited[idx]==0) dfs(arr,idx,visited);
        }
    }
}