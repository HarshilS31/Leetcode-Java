class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n-k;i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++) set.add(nums[j]);
            for(int num:set) map.put(num,map.getOrDefault(num,0)+1);
        }
        int res = -1;
        if(map.isEmpty()) return res;
        for(int key:map.keySet()) {
            if(map.get(key)==1)  res=Math.max(res,key);
        }
        return res;
    }
}