class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) { 
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr= new ArrayList<>();

        findSubsets(nums,ans,arr,target,0);
        return ans; 
    }

    void findSubsets(int[] nums,List<List<Integer>> ans,List<Integer> arr,int target,int idx) {
        if(target==0) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        
        if(idx==nums.length || target<0) return;
         
        if(nums[idx]<=target) {
            arr.add(nums[idx]);
            findSubsets(nums,ans,arr,target-nums[idx],idx);
            arr.remove(arr.size()-1);

        }
        findSubsets(nums,ans,arr,target,idx+1);
    }
}