package tasks;

/**
 *
 * Даны два целых неотрицательных числа,
 * которые представлены в виде связного списка в реверсивном порядке.
 *
 * Необходимо сложить этих два числа и получить такой же список.
 *
 * Пример:
 * (2 -> 4 -> 3) + (5 -> 6 -> 4) = (7 -> 0 -> 8)
 *
 * TODO : проверить корнер кейсы и корректность алгоритма
 * TODO :    (так как появляется лишний лидирующий ноль для данного реверсивного порядка)
 *
 * Created by toctep on 15.02.17.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(0);

        head.next = node;

        while (l1 != null || l2 != null) {
            int sum = l1.value + l2.value;
            node.value = node.value + sum % 10;
            node.next = new ListNode(sum / 10);

            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        while (node != null){
            System.out.print(node.value);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
    }


    public static void main(String[] args) {
//        (2 -> 4 -> 3) + (5 -> 6 -> 4) = 7 -> 0 -> 8
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(addTwoNumbers(l1, l2));
    }


    private static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}

