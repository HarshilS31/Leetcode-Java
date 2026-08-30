class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int[] primes = new int[n];
        Arrays.fill(primes,1);
        primes[0]=0;
        primes[1]=0;
        for(int i=2;i*i<n;i++) {
            if(primes[i]==1) {
                for(int j=i*i;j<n;j+=i) {
                    primes[j]=0;
                }
            }
        }
        int count=0;
        for(int k:primes) {
            if (k==1) count++;
        }
        return count;
        
    }
}