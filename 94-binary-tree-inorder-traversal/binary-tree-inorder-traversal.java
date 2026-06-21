class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while(true) {
            if(node!=null) {
                s.push(node);
                node=node.left;
                
            } else {
                if(s.isEmpty()) break;
                node=s.pop();
                ans.add(node.val);
                node=node.right;
            }       
        }
        return ans; 
    }
}