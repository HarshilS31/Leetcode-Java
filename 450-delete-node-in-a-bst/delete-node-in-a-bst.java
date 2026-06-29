class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delNode(root, key);
    }
    public TreeNode delNode(TreeNode node, int key) {
        if (node == null) return null;
        if (node.val > key) {
            node.left = delNode(node.left, key); 
        } else if (node.val < key) {
            node.right = delNode(node.right, key); 
        } else {
            if (node.left == null) return node.right; 
            else if (node.right == null) return node.left;
            else {

                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = node.left; 
                return node.right; 
            }
        }
        return node; 
    }
}