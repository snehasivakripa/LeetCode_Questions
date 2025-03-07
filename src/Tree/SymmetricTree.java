package Tree;

public class SymmetricTree {


    public static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(Integer val) {
            this.val = val;
        }

        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    private TreeNode createBinary(Integer[] arr, int index) {
        if(arr.length==0) return null;
        TreeNode root=null;
        if(index<arr.length){
            root=new TreeNode(arr[index]);
            root.left=createBinary(arr,2*index+1);
            root.right=createBinary(arr,2*index+2);
        }
        return root;
    }
    public boolean isSymmetric(TreeNode root) {

        TreeNode p=root;
        TreeNode q=root;

        return isSymmetricTree(p,q);
    }
    public boolean isSymmetricTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.val==q.val && isSymmetricTree(p.left,q.right) && isSymmetricTree(p.right,q.left);

    }

    public static void main(String[] args){

        Integer[] arr1={1,2,2,null,3,null,3};
        SymmetricTree symmetric=new SymmetricTree();
        TreeNode root1=symmetric.createBinary(arr1,0);
        System.out.println(symmetric.isSymmetric(root1));

    }
}
