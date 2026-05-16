class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        combinations(ans,nums,target,arr,0);
        return ans;
        
    }
    void combinations(List<List<Integer>> ans,int[] nums, int target,List<Integer> arr,int idx) {
        if(target==0) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (idx==nums.length || target <0 ) return;
        arr.add(nums[idx]);
            combinations(ans,nums,target-nums[idx],arr,idx);
            arr.remove(arr.size()-1);
            combinations(ans,nums,target,arr,idx+1);
    }
}