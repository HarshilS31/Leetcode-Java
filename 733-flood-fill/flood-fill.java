class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int initialColor=image[sr][sc];
        image[sr][sc]=color;
        q.add(new int[]{sr,sc});
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(q.size()>0) {
            int[] front = q.remove();
            for(int[] d:directions) {
                int i1=front[0]+d[0];
                int j1=front[1]+d[1];
                if( i1>=0 && j1>=0 && i1<image.length && j1<image[0].length && image[i1][j1]==initialColor && color!=initialColor) {
                    image[i1][j1]=color;
                    q.add(new int[]{i1,j1});

                }
            }

        }
        return image;
        
    }
}