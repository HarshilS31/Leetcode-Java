class Solution {
    class Tuple {
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        // BFS Queue
        Queue<Tuple> q = new LinkedList<>();
        
        // map: col -> (row -> PriorityQueue of node values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple top = q.poll();
            TreeNode node = top.node;
            int row = top.row;
            int col = top.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);
            if (node.left != null)  q.add(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) q.add(new Tuple(node.right, row + 1, col + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }

        return res;
    }
}