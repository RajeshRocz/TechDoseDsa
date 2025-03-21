package dsa.heap;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode l : lists) {
            if(l!=null) {
                minHeap.add(l);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;

        while (!minHeap.isEmpty()) {
            ListNode topNode = minHeap.poll();
            currentNode.next = topNode;
            currentNode = currentNode.next;
            if (topNode.next != null) {
                minHeap.add(topNode.next);
            }

        }

        return dummy.next;
    }
}

class ListNode {
  int val;
  ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
