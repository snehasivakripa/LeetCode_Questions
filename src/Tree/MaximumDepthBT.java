package Tree;

public class MaximumDepthBT {

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

    public int maxDepth(TreeNode root) {
        int max=0;
        if(root!=null) {
            max = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return max;
    }

    public static void main(String[] args){
        Integer[] arr={1,null,2};
        MaximumDepthBT tree=new MaximumDepthBT();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.maxDepth(root));
    }

}
