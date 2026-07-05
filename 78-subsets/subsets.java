class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        findSubsets(nums,list,arr,0);   
        return list;     
    }
    public void findSubsets(int[] nums,List<List<Integer>> list,List<Integer> arr,int index) {
        if(index>=nums.length) {
            list.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[index]);
        findSubsets(nums,list,arr,index+1);
        arr.remove(arr.size()-1);
        findSubsets(nums,list,arr,index+1);

        

    }
}