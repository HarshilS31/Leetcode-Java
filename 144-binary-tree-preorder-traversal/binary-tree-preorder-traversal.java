
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Iterative Preorder Traversal
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode top=s.pop();
            ans.add(top.val);
            if(top.right!=null) s.push(top.right);
            if(top.left!=null) s.push(top.left);
        }
        return ans;
    }
}