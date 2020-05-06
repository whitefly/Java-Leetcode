package 链表;

import java.util.LinkedList;

public class 双向链表<E> {

    protected Node first;
    protected Node last;
    private int count = 0;

    class Node {
        private E val;
        private Node prev;
        private Node next;

        public Node(E val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }


    public boolean addFirst(E e) {
        Node f = first;
        Node newNode = new Node(e, null, first);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        count++;
        return true;
    }

    private boolean addLast(E e) {
        Node l = last;
        Node newNode = new Node(e, l, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        count++;
        return true;
    }

    public boolean add(E e) {
        return addLast(e);
    }

    private boolean addBefore(E e, Node n) {
        Node prev = n.prev;
        Node newNode = new Node(e, prev, n);
        n.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        count++;
        return true;
    }

    private Node node(int index) {
        if (index >= count) throw new IndexOutOfBoundsException();
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(E e, int index) {
        if (index > count) throw new IndexOutOfBoundsException();

        if (index == count) addLast(e);
        else addBefore(e, node(index));
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = first;
        for (int i = 0; i < count; i++) {
            sb.append(n.val.toString()).append("<--->");
            n = n.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        双向链表<Integer> list = new 双向链表<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.insert(3, 2);
        System.out.println("Ok");
    }
}
