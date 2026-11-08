class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        int lastA= -1;
        long count=0;
        for(int i=0;i<n;i++) {
            if(i>=2 && s.charAt(i)=='c' && s.charAt(i-1)=='b' && s.charAt(i-2)=='a') lastA=i-2; 
            count+=i-lastA;
        }
        return count;   
    }
}