import javax.swing.tree.TreeNode;

public class MaxDepthBT {

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

    public TreeNode insertLevelOrder(Integer[] arr, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left=insertLevelOrder(arr,2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }
}
    public int maxDepth(TreeNode root) {
    int depth=0;
       if(root==null){
           return 0;
       }else if(root.left==null||root.right==null){
           return 1;
       }else{
           while(root!=null){
               if(root.left!=null||root.right!=null){
                   depth++;
               }
               if(root.right==null){
                   root=root.left;
               }
               if(root.left==null){
                   root=root.right;
               }
               maxDepth(root.left);
               maxDepth(root.right);
           }
       }
       return depth;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        Integer[] arr= { 3,9,20, null, null,15,7};
        t2.insertLevelOrder(arr, 0);
    }
}
