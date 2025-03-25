package Tree;

public class DiameterTree {
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

    public int diameterOfBinaryTree(TreeNode root) {
        int len=0;
        return diameterBT(root,len);
    }

    private int diameterBT(TreeNode root, int len) {

        if(root!=null) {
            int left=diameterBT(root.left,len);
            int right=diameterBT(root.right,len);
            len= Math.max(len,left+right);
            return Math.max(left,right)+1;
        }else
        return 0;
    }

    public static void main(String[] args){
        Integer[] arr={1,2,3,4,5};
        DiameterTree tree=new DiameterTree();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.diameterOfBinaryTree(root));
    }
}
