class Solution {
    public int splitNum(int num) {
        char[] digits= Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        int k=digits.length/2;
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i=0;i<digits.length;i+=2){
            num1.append(digits[i]);
            if(i+1<digits.length) {
                num2.append(digits[i+1]);
            }
            
        }
        int n1 = Integer.parseInt(num1.toString());
        int n2 = Integer.parseInt(num2.toString());
        return n1+n2;      
    }
}