class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int revDegree = 0;
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            revDegree+=(i+1)*(26-(ch-'a'));
        }
        return revDegree;

    }
}