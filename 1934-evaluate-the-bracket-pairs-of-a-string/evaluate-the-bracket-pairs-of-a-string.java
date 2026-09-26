class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map =new HashMap<>();

        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                i++;
                int left=i;

                while(i<s.length() && s.charAt(i)!=')'){
                    i++;
                }
                String key = s.substring(left, i);
                if(map.containsKey(key)){
                    sb.append(map.get(key));
                }else sb.append("?");
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}