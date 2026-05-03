class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> ans=new ArrayList<>();
        int[] newInterval=intervals[0];
        ans.add(newInterval);

        for(int[] interval:intervals) {
            if(newInterval[1]>=interval[0]) {
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
            else {
                newInterval=interval;
                ans.add(interval);
            }
        }
    return ans.toArray(new int[ans.size()][]);

    }
}