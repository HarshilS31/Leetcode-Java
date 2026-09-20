class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        for(int[] interval:intervals) {
            list.add(interval);
        }
        return merge(list.toArray(new int[list.size()][2]));
    
    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        for(int[] interval: intervals) {
            int currStart = curr[0];
            int currEnd = curr[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if(currEnd >= nextStart) {
                curr[1] = Math.max(currEnd,nextEnd);
            }
            else {
                res.add(curr);
                curr=interval;
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][2]);


        
    }
}