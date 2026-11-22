class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1)  return 1;
        Set<Integer> set = new HashSet<>();
        for(int num:nums) {
            set.add(num);
        }
        int maxCount=1;
        for(int num:set) {
            if(!set.contains(num-1)) {
                int currNum = num;
                int currCount=1;
                while(set.contains(currNum++)) {
                    currCount++;
                }
                maxCount = Math.max(currCount,maxCount);
            }
        }

        return maxCount-1;
    }
}