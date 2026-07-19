class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            last[ch-'a']= i;
        }
        Stack<Integer> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(set.contains(ch))
                continue;
            while(!st.isEmpty()) {
                char prev = s.charAt(st.peek());
                if(prev > ch && last[prev-'a']>i) {
                    st.pop();
                    set.remove(prev);
                } else break;
            }

            st.push(i);
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(s.charAt(st.pop()));
        }
        sb.reverse();
        return sb.toString();
    }
}