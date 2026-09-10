class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> wordMapping = new HashMap<>();
        HashMap<String, Character> letterMapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            String s1 = words[i];

            if (wordMapping.containsKey(c1) && !wordMapping.get(c1).equals(s1)) {
                return false;
            }
            if (letterMapping.containsKey(s1) && !letterMapping.get(s1).equals(c1)) {
                return false;
            }

            wordMapping.put(c1, s1);
            letterMapping.put(s1, c1);
        }
        return true;
    }
}