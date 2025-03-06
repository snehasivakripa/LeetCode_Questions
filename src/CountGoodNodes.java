public class CountGoodNodes {

    public class Tree{
        public int value;
        public Tree left;
        public Tree right;
        public Tree(int value){
            this.value=value;
        }
        public Tree(int value, Tree left, Tree right){
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }

    private Tree buildTree(Integer[] array) {
        if(array==null|array.length==0){
            return null;
        }
        return convertToNode(array,0);
    }
    private Tree convertToNode(Integer[] array,int index) {

        if( index >= array.length || array[index] == null){
            return null;
        }
            Tree root = new Tree(array[index]);
            root.left = convertToNode(array,2*index+1);
            root.right = convertToNode(array, 2*index+2);
            return root;

    }


    public static void main(String[] args){
        Integer[] array={3,1,4,3,null,1,5};
        CountGoodNodes count=new CountGoodNodes();
        Tree root=count.buildTree(array);
       System.out.println(count.goodNodes(root,root.value));
    }

    private int goodNodes(Tree root,int max) {
        int count=0;
         if(root!=null) {
            if (root.value >= max) {
               count=1;
            }
            count+=goodNodes(root.left,Math.max(max, root.value));
             count+=goodNodes(root.right, Math.max(max, root.value));
        }
        return count;
    }

}
