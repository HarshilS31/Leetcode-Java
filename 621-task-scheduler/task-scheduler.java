class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char task:tasks) freq[task-'A']++;
        for(int i=0;i<26;i++) {
            if(freq[i]>0) pq.add(freq[i]);
        }
        int intervals =0;
        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()) {
                    int top = pq.poll();
                    top--;
                    temp.add(top);
                }
            }
            for(int f:temp) {
                if(f>0) pq.add(f);
            }
            intervals+=(pq.isEmpty() ?  temp.size() : n+1);
        }
        return intervals; 
    }
}