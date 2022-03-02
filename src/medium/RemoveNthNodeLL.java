package medium;

import medium.utils.Node;

public class RemoveNthNodeLL {
    public void removeNthNode(Node head, int n) {
        if(head == null) {
            return;
        }

        Node first = head;
        Node second = head;
        Node prev = null;
        int i = 0;

        while(i <= n) {
            second = second.next;
            i++;
        }

        while(second != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }

        if(first == head) {
            Node temp = head;
            head = temp.next;
            temp = null;
        }
        else {
            prev.next = first.next;
            first = null;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeLL r = new RemoveNthNodeLL();
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        r.removeNthNode(head, 3);
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
