class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n  = img1.length;
        int maxOverLap = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                if(img1[i][j]==1) {
                    for(int p=0;p<n;p++) {
                        for(int q=0;q<n;q++) {
                            if(img2[p][q]==1) {
                                String shift = (i-p)+","+(j-q);
                                map.put(shift,map.getOrDefault(shift,0)+1);
                                maxOverLap = Math.max(maxOverLap,map.getOrDefault(shift,0));
                            }
                        }
                    }

                }
            }
        }
        return maxOverLap;

        
    }
}