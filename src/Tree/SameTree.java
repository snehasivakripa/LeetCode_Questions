package Tree;

public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }

        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args){

        Integer[] arr1={1,2,3};
        Integer[] arr2={1,2,3};
        SameTree same=new SameTree();
        TreeNode root1=same.createBinary(arr1,0);
        TreeNode root2=same.createBinary(arr2,0);
        System.out.println(same.isSameTree(root1,root2));

    }
    
    
}
