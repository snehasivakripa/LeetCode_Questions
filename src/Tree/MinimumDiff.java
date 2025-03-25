package Tree;

public class MinimumDiff {
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
            if (arr[index] != null) {
                root = new TreeNode(arr[index]);
                root.left = createBinary(arr, 2 * index + 1);
                root.right = createBinary(arr, 2 * index + 2);
            }
        }
        return root;
    }

    public int getMinimumDifference(TreeNode root) {
        int len=0;
        return minDiff(root,len);
    }

    private int minDiff(TreeNode root, int len) {

        if(root!=null && root.left!=null && root.right!=null) {
            len=Math.min(Math.abs(root.val-root.left.val),Math.abs(root.val-root.right.val));
            minDiff(root.left,len);
            minDiff(root.right,len);
            return len;
        }else
            return 0;
    }

    public static void main(String[] args){
        Integer[] arr={4,2,6,1,3};
        MinimumDiff tree=new MinimumDiff();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.getMinimumDifference(root));
    }
}
