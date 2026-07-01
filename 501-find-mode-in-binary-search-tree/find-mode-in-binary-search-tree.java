class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        searchModes(root, map);
        int maxFreq = 0;
        for (int freq : map.values()) {
            if (freq > maxFreq) maxFreq = freq;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                arr.add(key);
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
    public void searchModes(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        searchModes(root.left, map);

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        searchModes(root.right, map);
    }
}