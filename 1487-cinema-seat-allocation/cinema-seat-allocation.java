class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        int totalFamilies = (n - rowMasks.size()) * 2;
        int leftMask   = 0b0111100000; 
        int rightMask  = 0b0000011110; 
        int middleMask = 0b0001111000; 
        for (int mask : rowMasks.values()) {
            boolean leftFree   = (mask & leftMask) == 0;
            boolean rightFree  = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;
            if (leftFree && rightFree) {
                totalFamilies += 2;
            } else if (leftFree || rightFree || middleFree) {
                totalFamilies += 1;
            }
        }
        return totalFamilies;
    }
}