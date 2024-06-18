import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> sumA  = new ArrayList<>();
        ArrayList<Integer> sumB  = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sumA.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                sumB.add(l2.val);
                l2 = l2.next;
            }

        }
        BigInteger revSumA = convertArrayListToNumber(sumA);
        BigInteger revSumB = convertArrayListToNumber(sumB);
        BigInteger result = revSumA.add(revSumB);

        return createLinkedListFromNumber(result);
    }
    public static BigInteger convertArrayListToNumber(ArrayList<Integer> digits) {
        Collections.reverse(digits);
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return new BigInteger(sb.toString());
    }

    public static ListNode createLinkedListFromNumber(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        ListNode node = new ListNode();
        ListNode current = node;

        String numStr = number.toString();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int digit = numStr.charAt(i) - '0'; //covert sting to int
            current.next = new ListNode(digit);
            current = current.next;
        }

        return node.next;
    }

    public static ListNode createLinkedList(int[] numbers) {
        ListNode node = new ListNode();
        ListNode current = node;
        for (int number : numbers) {
            current.next = new ListNode(number);
            current = current.next;
        }
        return node.next;
    }



    // Main method for testing
    public static void main(String[] args) {
        // Test case 1
        ListNode l1 = createLinkedList(new int[]{9});
        ListNode l2 = createLinkedList(new int[]{1,9,9,9,9,9,9,9,9,9});

    }

}
