class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i=0;
        while(i<n && newInterval[0]>intervals[i][1]) {
            list.add(intervals[i++]);
        }
        while(i<n && intervals[i][0] <= newInterval[1])  {
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i<n) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][2]);   
    }
}