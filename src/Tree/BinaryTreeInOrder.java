package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrder {

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
    private List<Integer> printTree(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        return printTreeList(root,list);
    }

    private List<Integer> printTreeList(TreeNode root, List<Integer> list) {
        if(root!=null){
            printTreeList(root.left,list);
            if(root.val!=null)
            list.add(root.val);
            printTreeList(root.right,list);
        }
        return list;
    }

    public static void main(String[] args){
        Integer[] arr={1,2,3,4,5,null,8,null,null,6,7,9};
        BinaryTreeInOrder tree=new BinaryTreeInOrder();
        TreeNode root=tree.createBinary(arr,0);
        System.out.println(tree.printTree(root));
    }



}
