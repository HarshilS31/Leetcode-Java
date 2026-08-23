class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel=0;
        int currFuel=0;
        int startIdx=0;
        for(int i=0;i<cost.length;i++) {
            int gain =gas[i]-cost[i];
            totalFuel+=gain;
            currFuel+=gain;
            if(currFuel < 0) {
                startIdx=i+1;
                currFuel=0;
            }
        }
        return totalFuel>=0 ? startIdx : -1;
        
    }
}