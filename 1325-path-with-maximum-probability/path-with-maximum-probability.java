class Pair implements Comparable<Pair> {
    int node;
    double prob;
    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
    public int compareTo(Pair t) {
        return Double.compare(this.prob, t.prob);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++) {
            double prob = succProb[i]; 
            adj.get(edges[i][0]).add(new Pair(edges[i][1], prob)); 
            adj.get(edges[i][1]).add(new Pair(edges[i][0], prob));
        }
        
        double[] ans = new double[n];
        ans[start_node] = 1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start_node, 1.0)); 
        
        while(!pq.isEmpty()) {
            Pair front = pq.poll();
            int node = front.node;
            double prob = front.prob;
            
            if(prob < ans[node]) continue;
            
            for(Pair k : adj.get(node)) {
                double p = k.prob * prob;
                if(ans[k.node] < p) { 
                    ans[k.node] = p; 
                    pq.add(new Pair(k.node, p)); 
                } 
            }
        }
        return ans[end_node]; 
    }
}