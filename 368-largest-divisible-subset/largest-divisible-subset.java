class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);   
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];             
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {       
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {   
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
        }
        int max = 0, lastIdx = 0;
        for (int i = 0; i < n; i++) {        
            if (dp[i] > max) {
                max = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>(); 
        while (hash[lastIdx] != lastIdx) {
            ans.add(nums[lastIdx]);            
            lastIdx = hash[lastIdx];          
        }
        ans.add(nums[lastIdx]);              
        Collections.reverse(ans);             
        return ans;
    }
}