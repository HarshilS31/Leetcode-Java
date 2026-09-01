class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        long n2=n;
        if(n<0) {
            return findPower(1/x,-n2);
        }
        return findPower(x,n2); 
    }
    public double findPower(double x,long n) {
        if(n==1) return x;
        double half = findPower(x,n/2);
        if(n%2==0) return half*half;
        return half*half*x;
    }
}