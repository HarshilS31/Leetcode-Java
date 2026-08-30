class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int num:nums) {
            x^=num;
        }
        int rightMostBit = (x & x-1) ^ x;
        int b1=0;
        int b2=0;
        for(int num:nums) {
            if((num & rightMostBit)==0) b1^=num;
            else b2^=num;
        }
        return new int[]{b1,b2};
        
    }
}