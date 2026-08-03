class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        partitions(0,s,arr,res);
        return res;
    }
    public boolean isPalindrome(String s,int i,int j) {
        while(i<j) if(s.charAt(i++)!=s.charAt(j--)) return false;
        return true;
    }
    public void partitions(int idx,String s,List<String> arr,List<List<String>> res) {
        if(idx==s.length()) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=idx;i<s.length();i++) {
            if(isPalindrome(s,idx,i)) {
                arr.add(s.substring(idx,i+1));
                partitions(i+1,s,arr,res);
                arr.remove(arr.size()-1);
            }
        }
    } 
}