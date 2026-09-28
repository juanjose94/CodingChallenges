package org.example.hackerrank.intermediate;

import lombok.Getter;

import java.util.Objects;

public class MergeTwoSortedLinkedLists2 {

    public static void main(String[] args) {

        // 1. Read both Linked List Node until both are null
        // 2. Create a linked list with two value (while are sorting(?))

        SinglyLinkedListNode subnode_12 = new SinglyLinkedListNode();

        subnode_12.data = 3;
        subnode_12.next = null;

        SinglyLinkedListNode subnode_1 = new SinglyLinkedListNode();

        subnode_1.data = 2;
        subnode_1.next = subnode_12;

        SinglyLinkedListNode node1 = new SinglyLinkedListNode();
        node1.data = 1;
        node1.next = subnode_1;

        SinglyLinkedListNode subnode_2 = new SinglyLinkedListNode();

        subnode_2.data = 4;
        subnode_2.next = null;

        SinglyLinkedListNode node2 = new SinglyLinkedListNode();
        node2.data = 3;
        node2.next = subnode_2;


        recursivePrint(mergeLists(node1, node2));
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data < head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }
    }

    public static class SinglyLinkedListNode {
        @Getter
        int data;
        SinglyLinkedListNode next;

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void recursivePrint(SinglyLinkedListNode node) {
        if (Objects.isNull(node.next)){
            System.out.println(node.data);
            System.out.println("This ends here");
            return;
        }
        System.out.println(node.data);
        recursivePrint(node.next);
    }
}
