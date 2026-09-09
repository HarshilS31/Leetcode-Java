class Solution {
    public long countCommas(long n) {
        long lower =1000;
        long  count = 0;
        int commas=1;
        while(lower<=n) {
            long  upper =  (lower*1000)-1;
            if(n<upper) upper = n;
            count+=(upper-lower+1)*commas;
            commas++;
            lower*=1000;
        }
        return count;
        
    }
}