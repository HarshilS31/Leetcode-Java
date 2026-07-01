class Solution {
    private Integer prevVal = null;
    private int currCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        return modes.stream().mapToInt(i -> i).toArray();
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prevVal != null && node.val == prevVal) {
            currCount++;
        } else {
            currCount = 1;
        }
        if (currCount > maxCount) {
            maxCount = currCount;
            modes.clear();
            modes.add(node.val);
        } else if (currCount == maxCount) {
            modes.add(node.val);
        }
        
        prevVal = node.val;
        inorder(node.right);
    }
}