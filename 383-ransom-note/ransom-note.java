class Solution {
    public boolean canConstruct(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            char c = s2.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<m;i++) {
            char c = s1.charAt(i);
            if(!map.containsKey(c)) return false;
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.getOrDefault(c,0)==0) map.remove(c);
        }
        return true;
        
    }
}