class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost = 0;
        int edgesUsed = 0;
        int[] minDist = new int[n];
        for (int i = 1; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        boolean[] inMST = new boolean[n];
        int currNode = 0;
        
        while (edgesUsed < n - 1) {
            inMST[currNode] = true;
            int nextNode = -1;
            int nextMinDist = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                if (!inMST[i]) {
                    int dist = Math.abs(points[currNode][0] - points[i][0]) 
                             + Math.abs(points[currNode][1] - points[i][1]);
                    if (dist < minDist[i]) {
                        minDist[i] = dist;
                    }
                    
                    if (minDist[i] < nextMinDist) {
                        nextMinDist = minDist[i];
                        nextNode = i;
                    }
                }
            }
            
            minCost += nextMinDist;
            currNode = nextNode;
            edgesUsed++;
        }
        
        return minCost;
    }
}
