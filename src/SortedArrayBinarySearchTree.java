public class SortedArrayBinarySearchTree {

    public class Tree{
        public int value;
        public Tree left;
        public Tree right;
        public Tree(int value){
           this.value=value;
        }
        public Tree(int value,Tree left, Tree right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    private Tree buildBST(int[] array) {
        if(array==null|array.length==0){
            return null;
        }
        return convertToNode(array,0,array.length-1);
    }

    private Tree convertToNode(int[] array, int low, int high) {
        if(low>high){return null;}
        int mid=low+(high-low)/2;
        Tree root= new Tree(array[mid]);
        root.left=convertToNode(array,low,mid);
        root.right=convertToNode(array,mid+1,high);
        return root;
    }


    public static void main(String[] args){
        int[] array={1,2,3,4,5,6,7};
        SortedArrayBinarySearchTree sorted=new SortedArrayBinarySearchTree();
        sorted.buildBST(array);
    }




}
