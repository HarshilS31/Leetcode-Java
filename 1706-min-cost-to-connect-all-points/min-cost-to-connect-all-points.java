class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minDist = 0;
        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        for(int i = 0; i < n; i++) {
            int ux = points[i][0];
            int uy = points[i][1];
            for(int j = i + 1; j < n; j++) { 
                int vx = points[j][0];
                int vy = points[j][1];
                int dist = Math.abs(ux - vx) + Math.abs(uy - vy);
                pq.add(new int[]{i, j, dist});
            }
        }
        
        while(pq.size() > 0) {
            int[] top = pq.poll();
            int u = top[0];
            int v = top[1];
            int d = top[2];
            if(findParent(u, parent) == findParent(v, parent)) continue;
            minDist += d;
            union(u, v, parent, size);
        }
        return minDist;
    }
    
    public void union(int x, int y, int[] parent, int[] size) {
        x = findParent(x, parent);
        y = findParent(y, parent);
        
        if (x != y) { 
            if(size[x] > size[y]) {
                parent[y] = x;
                size[x] += size[y];
            } else { 
                parent[x] = y;
                size[y] += size[x];
            }
        }
    }
    
    public int findParent(int x, int[] parent) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x], parent);
    }
}