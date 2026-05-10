class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        if(mat.length==1 && mat[0].length==1) {
            return mat[0][0]==target;
        }
        int r=0;
        int c=mat[0].length-1;
        while(r<mat.length && c>=0) {
            if(mat[r][c]==target) return true;
            else if(target<mat[r][c]) c--;
            else if(target>mat[r][c]) r++;   
        }
        return false;


        
    }
}