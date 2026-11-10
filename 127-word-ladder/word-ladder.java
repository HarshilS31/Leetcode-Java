class Solution {
    class Pair {
        String s;
        int lvl;
        Pair(String s,int lvl) {
            this.s=s;
            this.lvl=lvl;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s:wordList) set.add(s);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()) {
            Pair top = q.poll();
            String str = top.s;
            int currLvl= top.lvl;
            if(str.equals(endWord)) return currLvl;
            for(int i=0;i<str.length();i++) {
                char[] temp = str.toCharArray();
                for(char c ='a';c<='z';c++) {
                    temp[i]=c;
                    String check = new String(temp);
                    if(set.contains(check)) {
                        q.add(new Pair(check,currLvl+1));
                        set.remove(check);
                    }
                }
            }
        }
        return 0;
        
    }
}