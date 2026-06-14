class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007L;
        long[] ans = new long[n];
        long[] count = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE);
        ans[0] = 0;
        count[0] = 1;
        
        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        for(int[] arr : roads) {
            adj.get(arr[0]).add(new long[]{arr[1], arr[2]});
            adj.get(arr[1]).add(new long[]{arr[0], arr[2]});
        }
        pq.offer(new long[]{0, 0});
        while(pq.size() > 0) {
            long[] top = pq.poll();
            int node = (int) top[0];
            long time = top[1];
            if (time > ans[node]) continue;
            for(long[] ele : adj.get(node)) {
                int node2 = (int) ele[0];
                long totalTime = ele[1] + time;
                
                if(totalTime == ans[node2]) {
                    count[node2] = (count[node2] + count[node]) % MOD;
                }
                else if(totalTime < ans[node2]) {
                    count[node2] = count[node];
                    ans[node2] = totalTime;
                    pq.offer(new long[]{node2, totalTime});
                }
            }
        }
        return (int) count[n - 1];
    }
}