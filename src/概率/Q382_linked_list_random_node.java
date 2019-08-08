package 概率;

import java.util.Arrays;
import java.util.Random;

public class Q382_linked_list_random_node {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    思入: 蓄水池算法,k=1的特例情况
     */

    private ListNode head;
    private Random r;

    public Q382_linked_list_random_node(ListNode head) {
        this.head = head;
        r = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int result = 0;
        ListNode index = head;
        for (int i = 1; index != null; i++, index = index.next) {
            if (r.nextInt(i) == 0) result = index.val;
        }
        return result;
    }

    public static void main(String[] args) {
        Random s = new Random();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Q382_linked_list_random_node solver = new Q382_linked_list_random_node(head);
        int[] result = new int[4];
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            result[solver.getRandom()]++;
        }
        System.out.println(Arrays.toString(result));


    }
}
