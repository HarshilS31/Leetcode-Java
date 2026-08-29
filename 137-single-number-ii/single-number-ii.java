class Solution {
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int num : nums) {
            ones = (num ^ ones) & ~twos;
            twos = (num ^ twos) & ~ones;
        }
        return ones;      
    }
}