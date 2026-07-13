class Solution {
    public int splitNum(int num) {
        char[] digits= Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        int num1=0;
        int num2=0;
        for(int i=0;i<digits.length;i+=2){
            num1=num1*10+(digits[i]-'0');
            if(i+1<digits.length) {
                num2=num2*10+(digits[i+1]-'0');
                
            }
            
        }  
        return num1+num2;    
    }
}