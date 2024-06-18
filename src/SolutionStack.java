import java.math.BigInteger;
import java.util.Stack;

public class SolutionStack {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        Stack<Integer> res = new Stack<Integer>();
        int sum = 0, rem = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = (rem + stack1.peek() + stack2.peek());

            res.add(sum % 10);

            rem = sum / 10;

            stack1.pop();
            stack2.pop();
        }

        while (!stack1.isEmpty()) {
            sum = (rem + stack1.peek());
            res.add(sum % 10);
            rem = sum / 10;
            stack1.pop();
        }

        while (!stack2.isEmpty()) {
            sum = (rem + stack2.peek());
            res.add(sum % 10);
            rem = sum / 10;
            stack2.pop();
        }

        while (rem > 0) {
            res.add(rem % 10);
            rem /= 10;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        Stack<Integer> reversed = new Stack<>();
        while (!res.isEmpty()) {
            reversed.add(res.pop());
        }

        while (!reversed.isEmpty()) {
            current.next = new ListNode(reversed.peek());
            current = current.next;
        }
        stack1.addAll(reversed);

        return current.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        SolutionStack solution = new SolutionStack();
        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}

