import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        int result = 0;
        while (l1 != null || l2 != null) {
            int sum = result;
            if (l1 != null) {
                sum +=  l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum +=  l2.val;
                l2 = l2.next;
            }

            result = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (result > 0){
            current.next = new ListNode(result);
        }
        return current.next;
    }



    // Helper function to create linked list from array of numbers
    public static ListNode createLinkedList(int[] numbers) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int number : numbers) {
            current.next = new ListNode(number);
            current = current.next;
        }
        return dummyHead.next;
    }

    // Helper function to print linked list
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
