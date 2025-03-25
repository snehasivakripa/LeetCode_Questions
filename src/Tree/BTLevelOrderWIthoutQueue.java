package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderWIthoutQueue {
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
        findLevelOrder(root, 0, result);
        return result;
    }
    public void findLevelOrder(TreeNode root,int level, List<List<Integer>> result){

        if(root==null) return;

        if(result.size()<=level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        findLevelOrder(root.left,level+1,result);
        findLevelOrder(root.right,level+1,result);
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        BTLevelOrderWIthoutQueue level = new BTLevelOrderWIthoutQueue();
        TreeNode root = level.createBinary(arr, 0);
        System.out.println(level.levelOrder(root));
    }
}
