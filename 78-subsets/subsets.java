class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<Integer>(),0,nums);
        return res;
    }
    void solve(List<List<Integer>> res,List<Integer> arr,int i,int[] nums) {
        if(i==nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        solve(res,arr,i+1,nums);
        arr.remove(arr.size()-1);
        solve(res,arr,i+1,nums);

    }
}