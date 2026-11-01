class Solution {
    public int[] findOrder(int n, int[][] courses) {
        List<Integer>[] adj = new List[n];
        int[] inDegree = new int[n];
        int[] res = new int[n];
        int idx=0;
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] k : courses) {
            adj[k[1]].add(k[0]);
            inDegree[k[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (inDegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int top = q.poll();
            res[idx++]=top;
            for (int course : adj[top]) {
                inDegree[course]--;
                if (inDegree[course] == 0) q.add(course);
            }
        }
        return idx==n ? res : new int[]{};

    }
}