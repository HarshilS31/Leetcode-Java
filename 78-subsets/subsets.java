class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets =  1 << n;
        List<List<Integer>> res = new ArrayList<>();
        for(int num = 0 ;num<subsets;num++) {
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++) {
                if(((num) & (1<<i)) !=0) arr.add(nums[i]);
            }
            res.add(arr);
        }
        return res;
        
    }
}