class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9L) {
            return "";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }

        return sb.toString();
    }
}