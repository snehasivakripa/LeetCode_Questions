package Tree;

public class MaxPathSum {
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

    public static void main(String[] args){
        Integer[] arr={1,2,3};
        MaxPathSum tree=new MaxPathSum();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.maxPathSum( root));
    }

    private int maxPathSum(TreeNode root) {
        int sum=0;
        return maxSum(root,sum);

    }

    private int maxSum(TreeNode root, int sum) {
        if(root==null) {return 0;}
            int left=maxSum(root.left, sum);

            int right=maxSum(root.right, sum);
        sum = Math.max(sum, sum + Math.max(left,right));
        return Math.max(sum,root.val+left+right);
    }


}
