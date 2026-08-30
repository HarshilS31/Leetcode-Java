class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx =0;
        int minNum =Integer.MAX_VALUE;
        int maxNum =Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(nums[i]>maxNum) {
                maxNum=nums[i];
                maxIdx=i;
            }
            if(nums[i]<minNum) {
                minNum=nums[i];
                minIdx=i;
            }
        }
        int r1 =n-Math.abs(minIdx-maxIdx)+1;
        int r2=Math.max(minIdx,maxIdx)+1;
        int r3=n-Math.min(minIdx,maxIdx);
        return Math.min(r1,Math.min(r2,r3));
    }
}