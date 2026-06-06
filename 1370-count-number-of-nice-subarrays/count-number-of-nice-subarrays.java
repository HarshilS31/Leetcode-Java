class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return niceSubArrays(nums,k)-niceSubArrays(nums,k-1);
    }
    public int niceSubArrays(int[] nums,int k) {
        int left=0;
        int count=0;
        int oddNums=0;
        for(int right=0;right<nums.length;right++) {
            if(nums[right]%2==1) oddNums++;
            while(oddNums>k) {
                if(nums[left]%2!=0) {
                    oddNums-- ;
                    
                }
                left++;

            }
            count+=right-left+1;
        }
        return count;
    }
}