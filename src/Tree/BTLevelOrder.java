package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {
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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> levelList = new ArrayList<>(level);
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    levelList.add(curr.val);
                }
                if (curr.left != null && curr.right != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        BTLevelOrder level = new BTLevelOrder();
        TreeNode root = level.createBinary(arr, 0);
        System.out.println(level.levelOrder(root));
    }
}
