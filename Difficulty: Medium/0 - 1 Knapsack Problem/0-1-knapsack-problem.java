class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int[][] memo =  new int[val.length][W];
        for(int[] arr:memo) Arrays.fill(arr,-1);
        return maxVal(memo,val,wt,W,0);
        
    }
    public int maxVal(int[][] memo,int[] val,int[] wt,int W,int i) {
        if(i>=val.length || W<=0) return 0;
        if(memo[i][W-1]!=-1) return memo[i][W-1];
        if(wt[i]<=W) {
            int pick = val[i]+maxVal(memo,val,wt,W-wt[i],i+1);
            int skip = maxVal(memo,val,wt,W,i+1);
            memo[i][W-1]=Math.max(pick,skip);
            
        }
        else return memo[i][W-1]=maxVal(memo,val,wt,W,i+1);
        return memo[i][W-1];
        
    }
}
