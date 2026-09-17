class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
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
                list.add(curr);
                curr=interval;
            }
        }
        list.add(curr);
        return list.toArray(new int[list.size()][2]);


        
    }
}