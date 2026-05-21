

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLen=0;
        HashSet<Integer> set= new HashSet<>();
        for(int num:arr1) {
            while(num>0) {
                set.add(num);
                num/=10;
            }
        }
        for(int num:arr2){
            while(num>0) {
                if(set.contains(num)) {
                    int currLen=String.valueOf(num).length();
                    maxLen=(currLen > maxLen) ? currLen : maxLen;
                }
                num/=10;
            }
        }
        return maxLen;
 
    }
}