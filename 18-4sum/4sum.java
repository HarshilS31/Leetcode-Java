class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++) {
                if(j>i+1 &&  nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right =n-1;
                while(left<right) {
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                        while(left<right && nums[left-1]==nums[left]) left++;
                        while(left<right && right<n-1 && nums[right]==nums[right+1]) right--;   
                    }
                    else if(sum>target) {
                        right--;
                    }
                    else left++;

                }
            }
        }
        return res;
        
    }
}