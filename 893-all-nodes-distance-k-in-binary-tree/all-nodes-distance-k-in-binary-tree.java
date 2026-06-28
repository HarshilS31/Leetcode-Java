class Solution {
    void findParent(TreeNode root,HashMap<TreeNode,TreeNode> map) {
        if(root==null) return;
        if(root.left!=null) map.put(root.left,root);
        findParent(root.left,map);
        if(root.right!=null) map.put(root.right,root);
        findParent(root.right,map);


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        findParent(root,map);
        Queue<TreeNode> q = new LinkedList<>();
        int level=0;
        q.add(target);
        visited.add(target);;
        while(q.size()>0) {
            int size=q.size();
            if(level==k) break;
            for(int i=0;i<size;i++) {
                TreeNode curr=q.poll();
                TreeNode parent = map.get(curr);
                if(curr.left!=null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(parent!=null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;

        }
        while(!q.isEmpty()) {
            TreeNode curr=q.poll();
            ans.add(curr.val);
        }
        return ans;

        
    }
}