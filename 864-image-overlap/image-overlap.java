class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(img1[i][j]==1) {
                    list1.add(new int[]{i,j});
                }
                if(img2[i][j]==1) {
                    list2.add(new int[]{i,j});
                }
            }
        }
        Map<String,Integer> map = new HashMap<>();
        int maxOverLap = 0;
        for(int[] p1 : list1) {
            for(int[] p2 : list2) {
                String shift = (p2[0]-p1[0])+","+(p2[1]-p1[1]);
                map.put(shift,map.getOrDefault(shift,0)+1);
                maxOverLap = Math.max(maxOverLap,map.get(shift));
            }
        }
        return maxOverLap;
  


        
    }
}