class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] curr = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int[] interval:intervals) {
            int currStart = curr[0];
            int currEnd = curr[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if(currEnd>=nextStart) {
                curr[1]=Math.max(currEnd,nextEnd);
            }
            else {
                list.add(curr);
                curr=interval;
            }     
        }
        list.add(curr);
        int n = list.size();
        int[][] res = new int[n][2];
        for(int i=0;i<n;i++) {
            res[i]=list.get(i);
        }
        return res;
        
    }
}