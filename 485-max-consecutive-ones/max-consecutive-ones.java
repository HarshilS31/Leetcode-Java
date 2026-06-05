class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int num:nums) {
            if(num==1) count++;
            else {
                maxCount=count>maxCount? count:maxCount;
                count=0;
            }
        }
        maxCount=count>maxCount? count:maxCount;

        return maxCount;
        
    }
}