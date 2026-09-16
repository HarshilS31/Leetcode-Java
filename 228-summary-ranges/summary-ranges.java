class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr = nums[i];
            while(i<n-1 && nums[i+1]==nums[i]+1) {
                i++;
            }
            if(curr!=nums[i]) {
                String s = curr + "->" + nums[i];
                res.add(s);
            } 
            else res.add(Integer.toString(nums[i]));
        }
        return res;
    }
}