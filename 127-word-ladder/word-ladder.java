class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<Pair> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            if(curr.word.equals(endWord)) return curr.level;
            for(int i=0; i<curr.word.length(); i++){
                char[] wordChars = curr.word.toCharArray();
                for(char c='a'; c<='z'; c++){
                    wordChars[i]=c;
                    String newWord = new String(wordChars);
                    if(wordSet.contains(newWord)){
                        wordSet.remove(newWord);
                        queue.add(new Pair(newWord, curr.level+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word=word;
        this.level=level;
    }
}
