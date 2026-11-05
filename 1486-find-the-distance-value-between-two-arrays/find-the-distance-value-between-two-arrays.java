class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int m=arr1.length;
        int n=arr2.length;
        int count = 0;
        for(int i=0;i<m;i++) {
            boolean include = true;
            for(int j=0;j<n;j++) {
                int dist = Math.abs(arr1[i]-arr2[j]);
                if(dist<=d) {
                    include=false;
                    break;
                }
            }
            if(include) count++; 
        }
        return count;
        
    }
}