class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        int uniqueCount = 0;
        for (int num = 100; num < 1000; num += 2) {
            if (canForm(num, count)) {
                uniqueCount++;
            }
        }
        return uniqueCount;   
    }
    public boolean canForm(int num,int[] count) {
        int[] tempCount = new int[10];
        while(num > 0 ){
            int temp = num%10;
            tempCount[temp]++;
            if(tempCount[temp]>count[temp]) return false;
            num/=10;
        }
        return true;
    }
}