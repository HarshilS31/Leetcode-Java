class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int mark=digits.length;
        for(int i=digits.length-1;i>0;i--) {
            if(digits[i-1]>digits[i]) {
                mark=i;
                digits[i-1]--;            
            }
        }
        for(int i=mark;i<digits.length;i++) digits[i]='9';
        return Integer.parseInt(new String(digits));
    }
}