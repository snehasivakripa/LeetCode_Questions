public class MergeKSortedList {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
       
        return mergeSortDivision(lists, 0, lists.length - 1);

    }
    private ListNode mergeSortDivision(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        if (low + 1 == high) {
            return merge(lists[low], lists[high]);
        }
            int mid = low + (high - low) / 2;
            ListNode left=mergeSortDivision(lists, low, mid);
            ListNode right=mergeSortDivision(lists, mid + 1, high);

        return merge(left,right);
    }

    private ListNode merge(ListNode l1,ListNode l2) {
        ListNode dup = new ListNode(0);
        ListNode curr=dup;
        while (l1!=null && l2!=null) {
            if (l1.val <= l2.val) {
                curr.next=l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                curr.next=l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null){
            curr.next=l1;
        }
        if(l2!=null){
            curr.next=l2;
        }

        return dup.next;
    }

        public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }


    public static void main(String[] args) {
        MergeKSortedList merge = new MergeKSortedList();
        ListNode list1 = merge.createList(new int[] {1, 4, 5});
        ListNode list2 = merge.createList(new int[] {1, 3, 4});
        ListNode list3 = merge.createList(new int[] {2, 6});

        // Create an array of linked lists
        ListNode[] lists = {list1, list2, list3};
        ListNode result= merge.mergeKLists(lists);
        merge.printList(result);
    }


}
