class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findParent(map, root);
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        visited.add(target);
        q.add(target);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if (level == k) break; 
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode parent = map.get(curr);
                if(curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        
        return ans;
    }

    void findParent(HashMap<TreeNode, TreeNode> map, TreeNode node) {
        if(node == null) return;
        
        if(node.left != null) {
            map.put(node.left, node);
            findParent(map, node.left);
        }
        if(node.right != null) {
            map.put(node.right, node);
            findParent(map, node.right);
        }
    }
}