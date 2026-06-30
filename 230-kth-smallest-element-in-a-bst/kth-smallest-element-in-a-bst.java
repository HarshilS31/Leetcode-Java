class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        return arr.get(k-1);
        
    }
    public void inOrder(TreeNode root,ArrayList<Integer> arr) {
        if(root==null) return;
        inOrder(root.left,arr);
        arr.add(root.val);
        inOrder(root.right,arr);
        
    }
}