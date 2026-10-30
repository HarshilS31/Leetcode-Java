class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=k;i++) {
            int[] temp = Arrays.copyOf(cost,n);
            for(int[] curr:flights) {
                int u = curr[0];
                int v = curr[1];
                int c = curr[2];
                if(cost[u]==Integer.MAX_VALUE) continue;
                if(temp[v]>c+cost[u]) {
                    temp[v]=cost[u]+c;
                }
            }
            cost=temp;
        }
        return cost[dst] == Integer.MAX_VALUE ?  -1:cost[dst];
        
    }
}