class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            adj[edge[1]].add(edge[0]);
        }

        // State array: 0 -> unvisited, 1 -> visiting, 2 -> visited
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(adj, state, i)) {
                    return false; 
                }
            }
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int[] state, int curr) {
        state[curr] = 1;
        for(int node:adj[curr]) {
            if(state[node]==1) return true;
            else if(state[node]==0) {
                if (hasCycle(adj,state,node)) return true;

            }
        }
        state[curr]=2;
        return false;
    }
}