class Solution {
    public int candy(int[] ratings) {
        //Brute force 
        int n =ratings.length;
        int[] candies =  new int[n];
        Arrays.fill(candies,1);
        for(int i=1;i<n;i++) {
            if(ratings[i]>ratings[i-1] && candies[i-1]>=candies[i]) {
                candies[i]+=candies[i-1]-candies[i]+1;
            }
        }
        for(int i=n-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1] && candies[i+1]>=candies[i]) {
                candies[i]+=candies[i+1]-candies[i]+1;
            }
        }
        int candyCount=0;
        for(int candy:candies) candyCount+=candy;
        return candyCount;
    }
}