package Tree;



import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return targetSum==root.val;
        }

        boolean left=hasPathSum(root.left,targetSum-root.val);
        boolean right=hasPathSum(root.right,targetSum-root.val);

        return left || right;
    }

    public static void main(String[] args){
        Integer[] arr={1,2,3,2,null,null,null,2};
        int target=22;
        PathSum path=new PathSum();
        TreeNode root=path.createBinary(arr,0);
       path.hasPathSum(root,target);
    }
}
