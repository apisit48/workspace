import java.math.BigInteger;

public class addTwoNumberSol2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = listToBigInteger(l1);
        BigInteger num2 = listToBigInteger(l2);

        BigInteger sum = num1.add(num2);

        return bigIntegerToList(sum);
    }

    private BigInteger listToBigInteger(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        sb.reverse();
        return new BigInteger(sb.toString());
    }

    public ListNode bigIntegerToList(BigInteger num) {
        if (num.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        ListNode node = new ListNode(0);
        ListNode current = node;

        String numStr = num.toString();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int digit = numStr.charAt(i) - '0'; //
            current.next = new ListNode(digit);
            current = current.next;
        }

        return node.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        addTwoNumberSol2 solution = new addTwoNumberSol2();
        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
