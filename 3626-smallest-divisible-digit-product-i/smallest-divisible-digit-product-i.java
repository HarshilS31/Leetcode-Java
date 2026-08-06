class Solution {
    public int smallestNumber(int n, int t) {
        int ans=0;
        while(true) {
            if((ProductOfDigits(n)%t)==0) {
                ans = n;
                break;
                
            }
            n++;
        }
        return ans;

    }
    public int ProductOfDigits(int num) {
        if(num<10) return num;
        int res=1;
        while(num>0) {
            res*=num%10;
            num/=10;
        }
        return res;
    }

}