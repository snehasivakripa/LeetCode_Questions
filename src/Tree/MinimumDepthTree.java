package Tree;

public class MinimumDepthTree {

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

    public TreeNode buildTree(Integer[] arr,int index){
        if(arr.length==0) return null;
        TreeNode root=new TreeNode();
        if (index< arr.length) {
            root=new TreeNode(arr[index]);
            root.left=buildTree(arr,2*index+1);
            root.right=buildTree(arr,2*index+2);
        }
        return root;
    }

    public static void main(String[] args){
        Integer[] arr={2,null,3,null,4,null,5,null,6};
        MinimumDepthTree tree=new MinimumDepthTree();
        TreeNode root=tree.buildTree(arr,0);
        System.out.println(tree.minDepth(root));
    }

    private int minDepth(TreeNode root) {
        if(root==null) return 0;
        int min=0;
        if(root!=null)
        min=1+Math.min(minDepth(root.left),minDepth(root.right));
        return min;
    }
}
