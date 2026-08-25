class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int missing = k;
        while(set.contains(missing)) {
            missing+=k;
        }
        return missing;

    }
}