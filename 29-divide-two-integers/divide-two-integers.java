class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE) {
            if(divisor==1) return Integer.MIN_VALUE;
            if(divisor==-1) return Integer.MAX_VALUE;
        }
        int quotient = 0;
        int s1=0;
        int s2=0;
        if(dividend<0) s1=1;
        if(divisor<0) s2=1;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        while(a>=b) {
            a-=b;
            quotient++;
        }
        if(s1!=s2) return -(quotient);
        return quotient;

        
    }
}