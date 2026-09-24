class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int smallestIdx = n+1;
        for(int i=0;i<n;i++) {
            if(sumOfDigits(nums[i])==i) return i;
        }
        return -1;
        
    }
    public int sumOfDigits(int num) {
        int sum=0;
        while(num>0) {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}