class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String s2 = new String(temp);
            map.putIfAbsent(s2, new ArrayList<>());
            map.get(s2).add(s);
        }
        return new ArrayList(map.values());
    }
}