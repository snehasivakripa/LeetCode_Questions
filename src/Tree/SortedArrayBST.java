package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedArrayBST {

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

    private TreeNode createBST(Integer[] arr) {
        return createBSTBalanced(arr,0,arr.length-1);
    }

    private TreeNode createBSTBalanced(Integer[] arr, int l, int r) {
        if(l>r){return null;}
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=createBSTBalanced(arr,l,mid-1);
        root.right=createBSTBalanced(arr,mid+1,r);

        return root;
    }

    public static void main(String[] args){
        Integer[] arr={-10,-3,0,5,9};
        SortedArrayBST tree=new SortedArrayBST();
        TreeNode root=tree.createBST(arr);
      System.out.println(tree.printTree(root));
    }

    private List<Integer> printTree(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        return printBSTBalanced(root,0,result);
    }

    private List<Integer> printBSTBalanced(TreeNode root,int index, List<Integer> result) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode tempNode=queue.poll();
            result.add(tempNode.val);

            if(tempNode.left!=null){
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
        return result;
    }


}
