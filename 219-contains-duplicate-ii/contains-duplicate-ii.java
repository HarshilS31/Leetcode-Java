class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Brute force
        int n = nums.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(!map.containsKey(nums[i]))  {
                map.put(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            else map.get(nums[i]).add(i);
        }
        for(List<Integer> list :map.values()) {
            if(list.size()<2) continue;
            for(int i=1;i<list.size();i++) {
                if(list.get(i)-list.get(i-1)<=k) return true;
            }
        }
        return false;
        
        
    }
}