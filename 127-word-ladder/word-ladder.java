class Solution {
    class Pair {
        String s;
        int level;
        Pair(String s,int level) {
            this.s=s;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> words) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for(String s : words) set.add(s);
        set.remove(beginWord);
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()) {
            Pair top = q.poll();
            String s = top.s;
            int level = top.level;
            if(s.equals(endWord)) return level;
            for(int i=0;i<s.length();i++) {
                for(char c='a';c<='z';c++) {
                    char[] replacedString = s.toCharArray();
                    replacedString[i]=c;
                    String curr = new String(replacedString);
                    if(set.contains(curr)) {
                        set.remove(curr);
                        q.add(new Pair(curr,level+1));
                    }
                }
            }
        }
        return 0;
        
        
        
    }
}