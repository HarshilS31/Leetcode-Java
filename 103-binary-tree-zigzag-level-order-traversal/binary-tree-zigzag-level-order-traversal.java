
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight=true;
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            int size =q.size();
            for(int i=0;i<size;i++) {
                TreeNode front = q.poll();
                arr.add(front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);

            }
            if(leftToRight) {
                ans.add(arr);

            }
            else  {
                Collections.reverse(arr);
                ans.add(arr);

            }
            leftToRight=!leftToRight;

        }
        return ans;  
    }
}