class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(color==initialColor) return image;
        dfs(image,sr,sc,color,initialColor);
        image[sr][sc]=color;
        return image;
   
    }
    void dfs(int[][] image,int i,int j,int color,int initialColor) {
        if(i<0 || j<0 || i>=image.length || j>=image[0].length) return;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        
        if(image[i][j]==initialColor) {
            image[i][j]=color;
            for(int[] d:directions) dfs(image,i+d[0],j+d[1],color,initialColor);
        }
    }
}

//         BFS
        // Queue<int[]> q = new LinkedList<>();
        // int initialColor=image[sr][sc];
        // image[sr][sc]=color;
        // q.add(new int[]{sr,sc});
        // int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        // while(q.size()>0) {
        //     int[] front = q.remove();
        //     for(int[] d:directions) {
        //         int i1=front[0]+d[0];
        //         int j1=front[1]+d[1];
        //         if( i1>=0 && j1>=0 && i1<image.length && j1<image[0].length && image[i1][j1]==initialColor && color!=initialColor) {
        //             image[i1][j1]=color;
        //             q.add(new int[]{i1,j1});

        //         }
        //     }

        // }
        // return image;