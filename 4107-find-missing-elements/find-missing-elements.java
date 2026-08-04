class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        for(int num:nums) {
            maxVal=Math.max(maxVal,num);
            minVal=Math.min(minVal,num);
            set.add(num);
        }
        for(int i=minVal;i<=maxVal;i++) {
            if(!set.contains(i)) res.add(i);
        }
        return res;

        
    }
}