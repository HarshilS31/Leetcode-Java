class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        boolean[] isTravelDay = new boolean[maxDay + 1];
        for (int day : days) {
            isTravelDay[day] = true;
        }
        for (int i = 1; i <= maxDay; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int pass1 = dp[i - 1] + costs[0];
            int pass7 = dp[Math.max(0, i - 7)] + costs[1];
            int pass30 = dp[Math.max(0, i - 30)] + costs[2];
            
            dp[i] = Math.min(pass1, Math.min(pass7, pass30));
        }
        
        return dp[maxDay];
    }
}