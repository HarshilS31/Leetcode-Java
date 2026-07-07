class Solution {
    public long sumAndMultiply(int n) {
        if(n==0) return 0;
        StringBuilder num = new StringBuilder();
        String s = Integer.toString(n);
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(c!='0') num.append(c);
        }
        long val = Integer.parseInt(num.toString());
        long ans = val*SumOfDigits(val);
        return ans;
        
    }
    public long SumOfDigits(long val) {
        long sum=0;
        while(val>0) {
            sum+=val%10;
            val/=10;  
        }
        return sum;

    }
}