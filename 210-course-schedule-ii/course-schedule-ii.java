class Solution {
    public int[] findOrder(int n, int[][] courses) {
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] k : courses) {
            adj[k[1]].add(k[0]);
            inDegree[k[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (inDegree[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int top = q.poll();
            ans.add(top);
            for (int course : adj[top]) {
                inDegree[course]--;
                if (inDegree[course] == 0) q.add(course);
            }
        }
        if (ans.size() < n) return new int[0];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = ans.get(i);
        return result;
    }
}