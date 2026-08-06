class Solution {
    public long maxPairStrength(int[] nums) {
        int n=nums.length;
        long maxStrength=0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                long n1=nums[i];
                long n2=nums[j];
                long g = gcd(n1,n2);
                long strength=(long)(n1*n2)/(g*g);
                maxStrength = Math.max(maxStrength,strength);
            }
        }
        return maxStrength; 
    }
    long gcd(long a,long b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}