class Solution {
    public boolean checkDivisibility(int n) {
        int divisor = sumOfDigits(n) + productOfDigits(n);
        return (n%divisor==0);
    }
    int sumOfDigits(int num) {
        int sum=0;
        while(num >0) {
        sum+=num%10;
        num/=10;
        }
        return sum;

    }
    int productOfDigits(int num) {
        int product = 1;
        while(num>0) {
            product*=num%10;
            num/=10;    
        }
        return product;
    }
}