class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        findSubsets(nums,ans,arr,0);
        return ans;
 
    }
    void findSubsets(int[] nums,List<List<Integer>> ans,List<Integer> arr,int idx) {
        if(idx==nums.length) {
            ans.add(new ArrayList<>(arr));
            return;

        }
        arr.add(nums[idx]);
        findSubsets(nums,ans,arr,idx+1);
        arr.remove(arr.size()-1);
        findSubsets(nums,ans,arr,idx+1);

    }
}