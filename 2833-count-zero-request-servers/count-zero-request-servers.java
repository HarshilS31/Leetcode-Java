class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] res = new int[m];
        int[] serverFreq = new int[n + 1];
        int activeServers = 0;
        int left = 0, right = 0;
        int logsLen = logs.length;
        for (int i = 0; i < m; i++) {
            int queryTime = q[i][0];
            int originalIndex = q[i][1];
            int start = queryTime - x;
            int end = queryTime;
            while (right < logsLen && logs[right][1] <= end) {
                int serverId = logs[right][0];
                if (serverFreq[serverId] == 0) {
                    activeServers++;
                }
                serverFreq[serverId]++;
                right++;
            }
            while (left < logsLen && logs[left][1] < start) {
                int serverId = logs[left][0];
                serverFreq[serverId]--;
                if (serverFreq[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }
            
            res[originalIndex] = n - activeServers;
        }
        
        return res;
    }
}