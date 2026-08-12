class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen=0;
        int left=0;
        for(int i=0;i<n;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k){
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
            maxLen=Math.max(maxLen,i-left+1);
        }
        return maxLen;    
    }
}