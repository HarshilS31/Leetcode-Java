class Solution {
    public int minimumCost(int[] cost) {
        int totalCost=0;
        Arrays.sort(cost);
        int i=0;
        int j=cost.length-1;
        while(j>i) {
            int temp=cost[i];
            cost[i]=cost[j];
            cost[j]=temp;
            i++;
            j--;
        }
        for(int k=0;k<cost.length;k++) {
            if(k%3!=2) totalCost+=cost[k];
        }
        return totalCost;


        
    }
}