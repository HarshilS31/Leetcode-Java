class Solution {
    public int findGCD(int[] nums) {
        int max=Integer.MIN_VALUE;
        for (int i=0;i<=nums.length-1;i++) {
            if(nums[i]>max) max=nums[i];
            else continue;    
        }
        int min=Integer.MAX_VALUE;
        for (int i =0;i<=nums.length-1;i++) {
            if(nums[i]<min) min=nums[i];
            else continue;
        }
        int gcd=0;
        int currentgcd=0;
        for (int i =1;i<=min;i++) {
            if(min%i==0 && max%i==0) currentgcd=i;
            gcd=Math.max(gcd,currentgcd);
        }
        return gcd;

        

        
    }
}