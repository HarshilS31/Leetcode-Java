class Solution {
    public boolean isValidSudoku(char[][] arr) {
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] != '.') {
                    map1.put(arr[i][j], map1.getOrDefault(arr[i][j], 0) + 1);
                    if (map1.get(arr[i][j]) > 1) return false;
                }
                if (arr[j][i] != '.') {
                    map2.put(arr[j][i], map2.getOrDefault(arr[j][i], 0) + 1);
                    if (map2.get(arr[j][i]) > 1) return false;
                }
            }
        }
        for (int b = 0; b < 9; b++) {
            HashMap<Character, Integer> map3 = new HashMap<>();
            int startRow = (b / 3) * 3;
            int startCol = (b % 3) * 3;
            
            for (int r = startRow; r < startRow + 3; r++) {
                for (int c = startCol; c < startCol + 3; c++) {
                    if (arr[r][c] != '.') {
                        map3.put(arr[r][c], map3.getOrDefault(arr[r][c], 0) + 1);
                        if (map3.get(arr[r][c]) > 1) return false;
                    }
                }
            }
        }

        return true;
    }
}