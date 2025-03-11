package Tree;

import java.util.*;

public class InvertBinaryTree {

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


    public TreeNode invertTree(TreeNode root) {

        TreeNode p=root;
        return invertedTree(p);

    }

    private TreeNode invertedTree(TreeNode p) {
       if(p==null) return null;
        if(p!=null) {
            invertedTree(p.left);
            invertedTree(p.right);

            TreeNode temp=p.left;
            p.left=p.right;
            p.right=temp;
        }
       return p;
    }

    private List<Integer> printTreeList(TreeNode root, List<Integer> list) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode=queue.poll();
            list.add(tempNode.val);

            if(tempNode.left!=null){
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null){
                queue.add(tempNode.right);
            }
        }
      return list;
    }

    public static void main(String[] args){

        Integer[] arr1={4,2,7,1,3,6,9};
        InvertBinaryTree invert=new InvertBinaryTree();
        TreeNode root1=invert.createBinary(arr1,0);
        TreeNode result=invert.invertTree(root1);
        List<Integer> output=new ArrayList<>();

        System.out.println(invert.printTreeList(result,output));

    }
}
