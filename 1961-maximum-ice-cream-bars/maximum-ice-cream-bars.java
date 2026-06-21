class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int icecreams=0;
        for(int cost:costs) {
            if (cost<=coins) {
                icecreams++;
                coins-=cost;
            }
        }
        return icecreams;

        
    }
}