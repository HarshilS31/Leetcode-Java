class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n;i++) {
            int temp = target-nums[i];
            int j=i+1;
            int k=n-1;
            while(k>j) {
                int currSum =nums[j]+nums[k];
                if(Math.abs(temp-currSum)<minDiff) {
                    sum=currSum+nums[i];
                    minDiff=Math.abs(temp-currSum);
                }
                if(temp>currSum) {
                    j++;
                }else {
                    k--;
                }
            }
            
        }
        return sum;
    }
}