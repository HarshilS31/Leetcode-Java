class Solution {
    public boolean canFinish(int n, int[][] preR) {
        int[] state = new int[n];
        List<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;i++) list[i]=new ArrayList<>();
        for(int[] course:preR) {
            list[course[1]].add(course[0]);
        }
        for(int i=0;i<n;i++) {
            if(state[i]==0) {
                if(hasCycle(list,state,i)) return false;
            }
        }
        return true;
    }
    public boolean hasCycle(List<Integer>[] list,int[] state,int i) {
        state[i]=1;
        for(int node:list[i]) {
            if(state[node]==1) return true;
            else if(state[node]==0 && hasCycle(list,state,node)) return true;
        }
        state[i]=2;
        return false;

    }
}