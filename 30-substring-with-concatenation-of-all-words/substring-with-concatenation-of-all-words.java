class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        if (s.length() < totalLen) return res;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i, count = 0;
            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);
                if (wordMap.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;
                    while (seen.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    if (count == numWords) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return res;
    }
}