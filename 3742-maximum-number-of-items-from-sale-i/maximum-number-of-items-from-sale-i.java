class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] factors = Arrays.stream(items).mapToInt(item -> item[0]).toArray();
        int[] prices = Arrays.stream(items).mapToInt(item -> item[1]).toArray();
        int cheapest = Arrays.stream(prices).min().getAsInt();
        int[] best = new int[budget + 1];  // no first copies yet: everything goes to the cheapest item
        Arrays.setAll(best, money -> money / cheapest);
        for (int[] item : items) {
            int factor = item[0], price = item[1];
            int gain = (int) Arrays.stream(factors).filter(other -> other % factor == 0).count();  // the copy itself + a free copy of every other multiple
            for (int money = budget; money >= price; money--)  // backwards: one first copy per item
                best[money] = Math.max(best[money], best[money - price] + gain);
        }
        return best[budget];
    }
}