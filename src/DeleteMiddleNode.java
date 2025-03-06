public class DeleteMiddleNode {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = head;


        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step.
            fast = fast.next.next;
        }

        // Skip the middle node. Slow pointer now points to the node before the middle node.
        slow.next = slow.next.next;

        // Return the modified list. The dummy's next points to the new list's head.
        return dummy.next;
    }
    public ListNode create(int[] arr){
          ListNode head=new ListNode(arr[0]);
          ListNode curr=head;
          for(int i=1;i< arr.length;i++){
              curr.next=new ListNode(arr[i]);
              curr=curr.next;
          }
          return head;
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
          DeleteMiddleNode delete=new DeleteMiddleNode();
          ListNode list1 = delete.create(new int[] {1, 4, 5});
          ListNode result=delete.deleteMiddle(list1);
          delete.printList(result);

    }
}
