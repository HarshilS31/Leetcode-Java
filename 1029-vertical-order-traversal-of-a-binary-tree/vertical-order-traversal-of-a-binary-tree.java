class Solution {
    class Tuple {
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // TreeMap<column,TreeMap<row,PQ(to store nodes)>
        Queue<Tuple> q = new LinkedList<>();
        if (root != null) {
            q.offer(new Tuple(root, 0, 0));
        }
        while (!q.isEmpty()) {
            Tuple current = q.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> verticalLine = new ArrayList<>();
            for (PriorityQueue<Integer> overlappingNodes : colMap.values()) {
                while (!overlappingNodes.isEmpty()) {
                    verticalLine.add(overlappingNodes.poll());
                }
            }
            result.add(verticalLine);
        }
        return result;
    }
}