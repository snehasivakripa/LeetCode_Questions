package Tree;

public class MaximumDepthNary {

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
            if(arr[index]!=null) {
                root = new TreeNode(arr[index]);
                root.left = createBinary(arr, 2 * index + 1);
                root.right = createBinary(arr, 2 * index + 2);
            }
        }
        return root;
    }
    public int maxDepth(TreeNode root){
        int maxDep=0;
        if(root!=null) {
            maxDep = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return maxDep;
    }
    public static void main(String[] args){
        Integer[] arr={1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14};
        MaximumDepthNary tree=new MaximumDepthNary();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.maxDepth(root));
    }
}
