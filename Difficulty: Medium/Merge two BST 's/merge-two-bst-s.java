class Solution {
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root1,arr);
        inorder(root2,arr);
        Collections.sort(arr);
        return arr;

    }
    void inorder(Node node,ArrayList<Integer> arr) {
        if(node==null) return;
        inorder(node.left,arr);
        arr.add(node.data);
        inorder(node.right,arr);
    }
}