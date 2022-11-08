package com.dodolu.test;

/**
 * Definition for singly-linked list.
 * class Node {
 *     int value;
 *     Node next;
 *     Node(int x) {
 *        value = x;
 *        next = null;
 *     }
 * }
 */

  class Node {
      int value;
      Node next;
      Node(int x) {
         value = x;
         next = null;
      }
  }
public class SingleLink {
    private Node head;//用来标记链表的起始位置

    //合并两个有序链表
    public Node mergeeTwoLink(SingleLink link) {
        if (link == null) {
            return head;
        }

        Node s;//用于链链表
        Node p = head;//用于遍历第一个链表
        Node q = link.head;//用于遍历第二个链表

        //标记合并后的链表头
        head = p.value < q.value ? p : q;

        //初始化s
        s = head;

        //谁小谁往后走
        if (head == p) {
            p = p.next;
        } else {
            q = q.next;
        }

        while (p != null && q != null) {
            if (p.value < q.value) {
                s.next = p;
                p = p.next;
            } else {
                s.next = q;
                q = q.next;
            }
            s = s.next;
        }

        //其中一个链表已经链完，为了链接另一个链表的剩余部分
        //如果p为null,s指向q,如果q为null，s指向p
        s.next = p == null ? q : p;
        return s;
    }
}

