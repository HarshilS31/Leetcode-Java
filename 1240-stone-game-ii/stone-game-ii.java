class Solution {
    public int stoneGameII(int[] piles) {
        int n =piles.length;
        int[][][] dp = new int[2][101][101];
        for(int[][] arr:dp) {
            for(int[] arr2:arr) Arrays.fill(arr2,-1);
        }
        return maxAliceScore(piles,1,0,n,1,dp); 
    }
    public int maxAliceScore(int[] piles,int person,int idx,int n,int M,int[][][] dp) {
        if(idx>=n) return 0;
        if(dp[person][idx][M]!=-1) return dp[person][idx][M];
        int res = person==1 ? -1:Integer.MAX_VALUE;
        int stones=0;
        for(int x=1;x<=Math.min(2*M,n-idx);x++) {
            stones+=piles[idx+x-1];
            if(person==1) {
                res=Math.max(res,stones+maxAliceScore(piles,0,idx+x,n,Math.max(x,M),dp));
            }
            else {
                res=Math.min(res,maxAliceScore(piles,1,idx+x,n,Math.max(x,M),dp));
            }
        }
        return dp[person][idx][M] = res;

    }
}