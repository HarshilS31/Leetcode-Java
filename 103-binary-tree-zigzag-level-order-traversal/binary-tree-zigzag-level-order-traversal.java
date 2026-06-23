class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight=true;
        q.add(root);
        while(q.size()>0) {
            int size =q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr=q.poll();
                arr.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(leftToRight) {
                ans.add(arr);
            }
            else {
                Collections.reverse(arr);
                ans.add(arr);
            }
            leftToRight=(!leftToRight);
            

        }
        return ans;
    }
}