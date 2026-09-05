class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==1) return;
        for(int col=0;col<n;col++){
            int row1=0;
            int rowN=n-1;
            while(row1<=rowN) {
                int temp=matrix[row1][col];
                matrix[row1++][col]=matrix[rowN][col];
                matrix[rowN--][col]=temp;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }   
    }
}