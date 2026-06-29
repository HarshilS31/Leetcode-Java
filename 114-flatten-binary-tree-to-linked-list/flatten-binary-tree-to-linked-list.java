
class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> a = new ArrayList<>();
        insertInArr(root,a);
        for (int i=0;i<a.size()-1;i++) {
            TreeNode b= a.get(i);
            TreeNode c= a.get(i+1);
            b.right=c; b.left=null;

        }
        TreeNode last=a.get(a.size()-1);
        last.right=null;
        last.left=null;


         
    }
    public static void insertInArr(TreeNode root,ArrayList<TreeNode> arr) {
        if(root==null) return;
        else arr.add(root);
        insertInArr(root.left,arr);
        insertInArr(root.right,arr);


    }
}