class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p,q); 
    }
    boolean check(TreeNode temp1,TreeNode temp2) {
        if(temp1==null && temp2==null ) return true;
        if((temp1==null && temp2!=null) || (temp2==null && temp1!=null)) return false;
        else if(temp1.val!=temp2.val) return false;
        return check(temp1.right,temp2.right) && check(temp1.left,temp2.left);
    }

}