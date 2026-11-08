class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long count = 0;
        int A=-1,AB=-1,ABC=-1;
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch=='a') A=i;
            else if(ch=='b') AB=A;
            else if(ch=='c') ABC=AB;
            count+=i-ABC;

        }
        return count;
        
    }
}