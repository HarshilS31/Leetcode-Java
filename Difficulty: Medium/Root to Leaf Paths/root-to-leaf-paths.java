class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPaths(root, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(Node node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> result) {
        if (node==null) return;
        currentPath.add(node.data);
        if(node.left==null && node.right==null) {
            result.add(new ArrayList<>(currentPath));
        }
        else {
            findPaths(node.left,currentPath,result);
            findPaths(node.right,currentPath,result);
            
        }
        currentPath.remove(currentPath.size()-1);
        
    

    }
}