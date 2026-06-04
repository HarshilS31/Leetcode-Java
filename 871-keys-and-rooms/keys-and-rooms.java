class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        visited[0]=true;
        dfs(rooms,visited,0);
        for(boolean opened:visited) {
            if(!opened) return false;
        }
        return true;    
    }
    
    void dfs(List<List<Integer>> rooms,boolean[] visited,int idx){
        visited[idx]=true;
        for(int key:rooms.get(idx)) {
            if(!visited[key]) dfs(rooms,visited,key);
        }



    }
}








    // void bfs(List<List<Integer>> rooms,boolean[] visited,int idx) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(idx);
    //     while(q.size()>0) {
    //         int front=q.remove();
    //         for(int key:rooms.get(front)) {
    //             if(!visited[key]) {
    //                 visited[key]=true;
    //                 q.add(key);
    //             }
    //         }
    //     }
    // }
//}