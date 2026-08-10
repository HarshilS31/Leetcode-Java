class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0]=true;
        bfs(0,visited,rooms);
        for(boolean check:visited) {
            if(!check) return false;
        }
        return true;
    }
    public void bfs(int idx,boolean[] visited,List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()) {
            int top = q.poll();
            for(int room : rooms.get(top)) {
                if(!visited[room]) {
                    visited[room]=true;
                    q.add(room);
                }
            }
        }
    }
}