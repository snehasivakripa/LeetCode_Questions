package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryPostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        return postorderList(root,result);

    }

    private List<Integer> postorderList(TreeNode root, List<Integer> result) {
        if(root!=null && root.val!=null){

            postorderList(root.left,result);
            postorderList(root.right,result);
            result.add(root.val);
        }
        return result;
    }

    public static void main(String[] args){
        Integer[] arr={1,2,3,4,5,null,8,null,null,6,7,null,null,9};
        BinaryPostorderTraversal tree=new BinaryPostorderTraversal();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.postorderTraversal(root));
    }
}
