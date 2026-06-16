class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        findSum(nums,target,arr,ans,0);
        return ans;
        
    }
    void findSum(int[] nums,int target,List<Integer> arr,List<List<Integer>> ans,int idx) {
        if(target==0) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(idx==nums.length || target<0) return;
        if(nums[idx]<=target) {
            arr.add(nums[idx]);
            findSum(nums,target-nums[idx],arr,ans,idx);
            arr.remove(arr.size()-1);
        }
        findSum(nums,target,arr,ans,idx+1);

    }
}