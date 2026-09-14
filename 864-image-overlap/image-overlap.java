class Solution {
    public int overlap(int[][] img1, int[][] img2,int rowOff,int colOff){
        int count=0;
        int n=img1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int b_i=i+rowOff;
                int b_j=j+colOff;
                if(b_i<0 || b_i>=n || b_j<0 || b_j>=n){
                    continue;
                }
                if(img1[i][j]==1 && img2[b_i][b_j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int ans=0;

        for(int rowOff=-n+1;rowOff<n;rowOff++){
            for(int colOff=-n+1;colOff<n;colOff++){
                int count=overlap(img1,img2,rowOff,colOff);
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}