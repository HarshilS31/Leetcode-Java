class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //Optimal
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.containsKey(nums[i])) {
                int prevIdx = map.get(nums[i]);
                if(i-prevIdx <= k) return true;
            }
            map.put(nums[i],i);
        }
        return false;  
    }
}