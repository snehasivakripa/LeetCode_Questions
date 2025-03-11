package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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
        Integer[] arr={1,2,3,null,5};
        BinaryTreePaths tree=new BinaryTreePaths();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.binaryTreePaths( root));
    }

    private List<String> binaryTreePaths(TreeNode root) {
        List<String> path=new ArrayList<>();
        return findPaths(root, path,new StringBuilder());
    }

    private List<String> findPaths(TreeNode root, List<String> path, StringBuilder str) {
        if(root!=null) {
            str.append(root.val);
            if (root.left == null && root.right == null) {
                path.add(str.toString());
            }else{
                findPaths(root.left, path, str);
                findPaths(root.right, path, str);
            }
        }
        return path;
    }
}
