class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] components = new int[n];
        for(int i=0;i<n;i++) components[i]=i;
        for(int i=0;i<n-1;i++) {
            int x = nums[i];
            int  y = nums[i+1];
            if(y-x <=maxDiff) components[i+1]=components[i];
        }
        for(int i=0;i<queries.length;i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            ans[i] = components[a]==components[b] ? true : false;
        }
        return ans; 
    }
}