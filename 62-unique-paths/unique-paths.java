class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1) return 1;
        int[] prev = new int[n];
        Arrays.fill(prev,1);
        for(int i=1;i<m;i++) {
            int[] curr=new int[n];
            for(int j=0;j<n;j++) {
                if(j==0) curr[j]=1;
                else curr[j]=prev[j]+curr[j-1];
            }
            for(int k=0;k<n;k++) prev[k]=curr[k];
        }
        return prev[n-1];

    }
}