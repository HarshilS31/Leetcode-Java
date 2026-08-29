class Solution {
    public int singleNumber(int[] nums) { 
        int res=0;
        for(int bit=0;bit<=31;bit++) {
            int count =0;
            for(int num:nums) {
                if((num & (1<<bit))!=0) count++;
            }
            if(count%3!=0) {
                res += 1 << bit;
            }
        }
        return res;
        
    }
}