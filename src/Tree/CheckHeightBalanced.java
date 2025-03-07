package Tree;

public class CheckHeightBalanced {

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



    public static void main(String[] args){
        Integer[] arr={3,9,20,null,null,15,7};
        CheckHeightBalanced tree=new CheckHeightBalanced();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.isBalanced(root));
    }

    private boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int h=maxDepth(root);
        if(h==-1) return false;
        return true;
    }

    private int maxDepth(TreeNode root) {
        if(root==null || root.val==null)return 0;
        int heightLeft=maxDepth(root.left);
        int heightRight=maxDepth(root.right);

        if(heightLeft==-1 || heightRight==-1) return -1;
        if(Math.abs(heightRight-heightLeft)>1) return -1;
        return 1+Math.max(heightLeft,heightRight);

    }
}
