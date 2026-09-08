class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        int digits = 0;
        int temp = n;
        while(temp>0) {
            temp/=10;
            digits++;
        }
        // int num = Math.pow(10,digits-1);
        int res = n-999;
        return res;

    }
}