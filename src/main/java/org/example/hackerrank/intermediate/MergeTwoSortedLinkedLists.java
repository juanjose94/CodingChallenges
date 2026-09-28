package org.example.hackerrank.intermediate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MergeTwoSortedLinkedLists {

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

        SinglyLinkedListNode listMerged = mergeLists(node1, node2);

        recursivePrint(listMerged);
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        List<SinglyLinkedListNode> resultList = new ArrayList<>();

        resultList = getSortToList(head1, resultList);
        resultList = getSortToList(head2, resultList);

        resultList.sort(Comparator.comparing(SinglyLinkedListNode::getData));

        return recursiveSaving(resultList.get(0), resultList, 0);
    }

    public static List<SinglyLinkedListNode> getSortToList(SinglyLinkedListNode head, List<SinglyLinkedListNode> currentList) {
        if (Objects.isNull(head)){
            return currentList;
        }
        SinglyLinkedListNode listNode = new SinglyLinkedListNode();
        listNode.data = head.data;
        listNode.next = null;
        currentList.add(listNode);
        return getSortToList(head.next, currentList);
    }

    public static SinglyLinkedListNode recursiveSaving(SinglyLinkedListNode current, List<SinglyLinkedListNode> sortedList, int index) {
        if (index + 1 == sortedList.size()) {
            current.data = sortedList.get(index).data;
            current.next = null;
            return current;
        }
        current.next = recursiveSaving(sortedList.get(index +1), sortedList, index +1);
        return current;
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

    public static class SinglyLinkedListNode {

        int data;
        SinglyLinkedListNode next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
