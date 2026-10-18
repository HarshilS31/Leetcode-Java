class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c:tasks) freq[c-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++) {
            if(freq[i]>0) pq.add(freq[i]);
        }
        int intervals =0;
        while(!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<=n;i++) {
                if(!pq.isEmpty()) {
                    int top = pq.poll();
                    top--;
                    list.add(top);
                }
            }
            for(int num:list) {
                if(num>0) pq.add(num);
            }
            intervals += pq.isEmpty() ? list.size(): n+1;
        }
        return intervals;
    }
}