class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode curr=s.pop();
            ans.add(curr.val);
            if(curr.right!=null) s.push(curr.right);
            if(curr.left!=null) s.push(curr.left);
        }
        return ans;
    }
}