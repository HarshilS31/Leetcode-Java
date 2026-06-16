class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        findSubSets(nums,ans,arr,0);     
        return ans;
    }
    void findSubSets(int[]nums,List<List<Integer>> ans,List<Integer> arr,int idx) {
        if(idx==nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        
        if(idx<nums.length) {
            arr.add(nums[idx]);
            findSubSets(nums,ans,arr,idx+1);
            arr.remove(arr.size()-1);
            findSubSets(nums,ans,arr,idx+1);
        }
    } 
}