/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] arr) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> isChild= new HashSet<>();
        for(int[] arr2:arr) {
            int parent=arr2[0];
            int child=arr2[1];
            int isLeft=arr2[2];
            if(!map.containsKey(parent)) {
                map.put(parent,new TreeNode(parent));
            }
            TreeNode parentNode=map.get(parent);
            if(!map.containsKey(child)) {
                map.put(child,new TreeNode(child));

            }
            TreeNode childNode=map.get(child);
            if(isLeft==1) parentNode.left=childNode;
            else parentNode.right=childNode;
            isChild.add(child);
        }
        for(int[] d:arr) {
            if(!isChild.contains(d[0])) {
                return map.get(d[0]);
            }
        }
        return null;


        
    }
}