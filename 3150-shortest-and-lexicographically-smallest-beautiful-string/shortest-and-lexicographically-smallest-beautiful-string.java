class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();        
        StringBuilder res =new StringBuilder();
        boolean found = false;
        for(int i=0;i<n;i++){
            StringBuilder temp = new StringBuilder();
            int oneCount=0;
            int j=i;
            while(j<n && oneCount<k) {
                if(s.charAt(j)=='1') oneCount++;
                temp.append(s.charAt(j++));
            }
            if(oneCount < k) continue;
            if(res.length()==0) {
                found = true;
                res = temp;   
            }
            else {
                if(res.length()>temp.length()) res = temp;
                if(res.length()==temp.length()) {
                    String r = res.toString();
                    String t = temp.toString();
                    if(r.compareTo(t)>0) res=temp;
                } 
            }
        }
        return found ? res.toString() : "";
    }
}