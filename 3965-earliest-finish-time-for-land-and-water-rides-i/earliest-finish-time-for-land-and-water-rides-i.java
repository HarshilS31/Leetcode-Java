class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int finishLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(finishLand, waterStartTime[j]);
                int totalTime1 = startWater + waterDuration[j];
                
                int finishWater = waterStartTime[j] + waterDuration[j];
                int startLand = Math.max(finishWater, landStartTime[i]);
                int totalTime2 = startLand + landDuration[i];
                minFinishTime = Math.min(minFinishTime, Math.min(totalTime1, totalTime2));
            }
        }
        
        return minFinishTime;
    }
}