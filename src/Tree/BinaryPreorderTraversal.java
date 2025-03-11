package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryPreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        return preorderList(root,result);

    }

    private List<Integer> preorderList(TreeNode root, List<Integer> result) {
        if(root!=null && root.val!=null){
            result.add(root.val);
            preorderList(root.left,result);
            preorderList(root.right,result);
        }
        return result;
    }

    public static void main(String[] args){
        Integer[] arr={1};
        BinaryPreorderTraversal tree=new BinaryPreorderTraversal();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.preorderTraversal(root));
    }
}
