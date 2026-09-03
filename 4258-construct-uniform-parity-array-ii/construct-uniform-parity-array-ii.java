class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        int minVal = Integer.MAX_VALUE;
        for(int num:nums1) {
            minVal = Math.min(num,minVal);
            if(num%2==1) allEven=false;
        }
        return allEven || minVal%2==1;
        
    }
}