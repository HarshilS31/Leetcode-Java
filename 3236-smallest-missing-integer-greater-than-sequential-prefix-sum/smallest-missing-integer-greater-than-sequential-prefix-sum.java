class Solution {
    public int missingInteger(int[] nums){
        int n=nums.length;
        if(n==1) return nums[0]+1;
        int prefixSum = nums[0];
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<n;i++) {
            if(nums[i]==nums[i-1]+1) {
                prefixSum+=nums[i];
            }
            else break;
        }
        for(int num:nums) {
            if(num>=prefixSum) set.add(num);
        }
        int ans = prefixSum;
        while(true) {
            if(!set.contains(ans)) break;
            else ans++;
        }
        return ans;
    }
}