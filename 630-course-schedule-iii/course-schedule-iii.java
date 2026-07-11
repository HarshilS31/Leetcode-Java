class Solution {
    public int scheduleCourse(int[][] courses) {
        int count = 0;
        Arrays.sort(courses,(a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for(int[] course : courses) {
            if(course[0]<=course[1]) {
                if(course[0]+time <= course[1]) {
                    pq.add(course[0]);
                    time+=course[0];
                }
                else {
                    
                    if(pq.peek()>course[0]) {
                        time-=pq.poll();
                        time+=course[0];
                        pq.add(course[0]);
                    }
                }

            }
        }
        return pq.size();
    }
}