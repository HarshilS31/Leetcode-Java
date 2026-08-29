class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        findSubsets(0,curr,res,nums);
        return res;
    }
    public void findSubsets(int idx,List<Integer>curr,List<List<Integer>>res,int[] nums) {
        if(idx==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        findSubsets(idx+1,curr,res,nums);
        curr.remove(curr.size()-1);
        findSubsets(idx+1,curr,res,nums);    
    }
}