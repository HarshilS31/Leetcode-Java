class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int[] arr:times) {
            int u = arr[0];
            int v = arr[1];
            int t = arr[2];
            list.get(u).add(new int[]{v,t});
        }
        int[] res = new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int t=top[1];
            if(t==Integer.MAX_VALUE) continue;
            for(int[] arr:list.get(node)) {
                int v = arr[0];
                if(res[v]>t+arr[1]) {
                    res[v]=t+arr[1];
                    pq.add(new int[]{v,res[v]});
                }
            }
        }
        int reqTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) reqTime = Math.max(reqTime,res[i]);
        return reqTime==Integer.MAX_VALUE ? -1:reqTime;

        
    }
}