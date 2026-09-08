class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[256];
        char[] map2 = new char[256];
        for(int i=0;i<s.length();i++) {
            char s1 =s.charAt(i);
            char t1 =t.charAt(i);
            if(map1[s1]=='\0' && map2[t1]=='\0') {
                map1[s1] = t1;
                map2[t1] = s1;
            }
            else if (map1[s1]!=t1 || map2[t1]!=s1) {
                return false;
            }
        }
        return true; 
    }
}