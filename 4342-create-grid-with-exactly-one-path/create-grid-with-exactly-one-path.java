class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        if(m==1) {
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<n;i++) temp.append('.');
            return  new String[]{temp.toString()};
        }
        if(n==1) {
            for(int i=0;i<m;i++) {
                StringBuilder temp = new StringBuilder();
                temp.append('.');
                res[i]=temp.toString();
            }
            return res;
        }
        for(int i=0;i<m;i++) {
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<n;j++) {
                if(i==0) {
                    if(j==n-1) temp.append('#');
                    else temp.append('.');
                }
                else if(i==m-1) {
                    if(j==n-2 || j==n-1) temp.append('.');
                    else temp.append('#');
                }
                else {
                    if(j==n-2) temp.append('.');
                    else temp.append('#');
                }
            }
            res[i]=temp.toString();
        }
        return res; 
    }
}