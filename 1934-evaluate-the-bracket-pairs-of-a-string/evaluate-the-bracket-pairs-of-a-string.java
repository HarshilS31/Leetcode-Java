class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        HashMap<String,String> map = new HashMap<>();
        for(List<String> list:knowledge) {
            map.put(list.get(0),list.get(1));
        }
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='(') {
                StringBuilder temp2 = new StringBuilder();
                temp2.append(s.charAt(++i));
                i++;
                while(s.charAt(i)!=')') {
                    temp2.append(s.charAt(i++));
                }
                String key = temp2.toString();
                System.out.println(key);
                if(!map.containsKey(key)) {
                    temp.append('?');
                }
                else temp.append(map.get(key)); 
            }
            else if (i<n) temp.append(s.charAt(i));
        }
        return temp.toString();
        
    }
}