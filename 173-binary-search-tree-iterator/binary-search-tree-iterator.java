
class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=s.peek();
        s.pop();
        pushAll(temp.right);
        return temp.val;
 
    }
    public boolean hasNext() {
        return !s.isEmpty();
        
    }
    public void pushAll(TreeNode node) {
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    }
}

