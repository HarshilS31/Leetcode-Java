class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            map.putIfAbsent(curr.hd, curr.node.data);

            if (curr.node.left != null)  q.add(new Pair(curr.node.left,  curr.hd - 1));
            if (curr.node.right != null) q.add(new Pair(curr.node.right, curr.hd + 1));
        }
        ans.addAll(map.values());
        return ans;
    }
}