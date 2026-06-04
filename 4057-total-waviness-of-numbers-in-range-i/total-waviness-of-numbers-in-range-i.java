class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness=0;

        for(int i=num1;i<=num2;i++){    
            waviness+=PeaksValleys(i);
        }
        return waviness;
        
    }
    int PeaksValleys(int num) {
        int peaks=0;
        int valleys=0;
        String str = String.valueOf(num);
        if(str.length()<3) return 0;
        for(int i=1;i<str.length()-1;i++) {
            int digit=str.charAt(i)-'0';
            int prevD=str.charAt(i-1)-'0';
            int nextD=str.charAt(i+1)-'0';
            if(digit<nextD && digit<prevD) valleys++;
            else if(digit>nextD && digit>prevD) peaks++;
        }
        return peaks+valleys;
    
        
    }
}