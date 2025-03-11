package Tree;

import java.util.ArrayList;
import java.util.List;

public class SumLeftLeaf {


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
        if (arr.length == 0) return null;
        TreeNode root = null;
        if (index < arr.length) {
            if (arr[index] != null) {
                root = new TreeNode(arr[index]);
                root.left = createBinary(arr, 2 * index + 1);
                root.right = createBinary(arr, 2 * index + 2);
            }
        }
        return root;
    }


    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeaves(root, 0);
    }

    private int sumOfLeaves(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfLeaves(root.left, sum);
        int rightSum = 0;
        if (root.right != null && root.right.left != null) {
            rightSum = sumOfLeaves(root.right, sum);
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        SumLeftLeaf tree = new SumLeftLeaf();
        TreeNode root = tree.createBinary(arr, 0);
        System.out.println(tree.sumOfLeftLeaves(root));
    }

}
