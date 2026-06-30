class Solution {
    boolean validBST=true;
    public boolean isValidBST(TreeNode root) { //O(N) space
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        for(int i=1;i<arr.size();i++) if(arr.get(i-1)>=arr.get(i)) return false;
        return true;
    }   
    public void inorder(TreeNode root,ArrayList<Integer> arr) {
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}