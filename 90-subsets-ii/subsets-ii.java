class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> arr= new ArrayList<>();
        Arrays.sort(nums);
        countSubsets(nums,ans,arr,0);
        return ans; 
    }
    public void countSubsets(int[] nums,List<List<Integer>> ans,List<Integer> arr,int idx) {
        if(nums.length==idx) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[idx]);
        countSubsets(nums,ans,arr,idx+1);
        arr.remove(arr.size()-1);
        int i=idx+1;
        while(i<nums.length && nums[i-1]==nums[i]) i++;
        countSubsets(nums,ans,arr,i);


    }
}