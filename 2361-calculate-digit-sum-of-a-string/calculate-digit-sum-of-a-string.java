class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k) {
            int n = s.length();
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<n;i+=k) {
                int val=0;
                for(int j=i;j<Math.min(n,i+k);j++) {
                    val+=s.charAt(j)-'0';
                }
                temp.append(val);
            }
            s=temp.toString();
        }
        return s;
        
    }
}