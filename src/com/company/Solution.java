package com.company;

public class Solution {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.reverseKGroup(node1,3);
    }

    /**
     * 25. Reverse Nodes in k-Group
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        int index = k;
        ListNode fake = new ListNode(-1);
        ListNode pre = fake;
        ListNode cur = head.next;
        ListNode first = null;
        ListNode left = head;
        ListNode right = head;
        while (cur != null){
            first = cur.next;
            cur.next = right;
            right = cur;
            cur = first;
            index--;
            if(index == 1){
                pre.next = right;
                pre = left;
                index = k;
                left = left.next;
            }
        }
        return fake.next;
    }


}
