class Pair implements Comparable<Pair> {
    int node;
    int time;
    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
    public int compareTo(Pair o) {
        return this.time - o.time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());
        for(int[] nodes:times) {
            int u=nodes[0];
            int v=nodes[1];
            int d=nodes[2];
            adj.get(u).add(new Pair(v,d));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(pq.size()>0) {
            Pair front = pq.poll();
            int node=front.node;
            int time=front.time;
            if(time>ans[node]) continue;
            for(Pair p:adj.get(node)) {
                int totalTime = time+p.time;
                if(totalTime<ans[p.node]) {
                    ans[p.node]=totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            if (ans[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ans[i]);
        }
        return max;
    }
}