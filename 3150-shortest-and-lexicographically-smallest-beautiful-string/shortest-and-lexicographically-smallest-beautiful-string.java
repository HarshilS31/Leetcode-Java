class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int oneCount=0;
        int i=0;
        int j=0;
        StringBuilder res = new StringBuilder();
        while(j<n) {
            if(s.charAt(j)=='1') oneCount++;
            while(i<n && (oneCount>k || s.charAt(i)=='0')) {
                if(s.charAt(i)=='1') oneCount--;
                i++;
            }
            if(oneCount==k) {
                StringBuilder temp = new StringBuilder(s.subSequence(i,j+1));
                if(res.length()==0 || res.length()>temp.length()) res=temp;
                else if(res.length()==temp.length()) {
                    String a = res.toString();
                    String b = temp.toString();
                    if(a.compareTo(b)>0) res=temp;
                }    
            }
            j++;
        }
        return res.toString();
    }
}