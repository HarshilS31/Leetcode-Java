class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        boolean[] removed = new boolean[n];
        List<String> res = new ArrayList<>();
        String compareWith = words[0];
        for(int i=1;i<n;i++) {
            if(areAnagrams(compareWith,words[i])) removed[i]=true;
            else compareWith=words[i];
        }
        for(int i=0;i<n;i++) {
            if(!removed[i]) res.add(words[i]);    
        }
        return res; 
    }
    public boolean areAnagrams(String a,String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i) - 'a']+=1;
            letters[b.charAt(i) - 'a']-=1;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}