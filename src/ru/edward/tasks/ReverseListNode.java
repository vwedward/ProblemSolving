/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

/**
 * Решение задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=d2d08macAH4&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=8
 */
// 1 -> 2 -> 3 -> null
// 3 -> 2 -> 1 -> null
public class ReverseListNode {

    public static class ListNode {
        public ListNode (ListNode next, int val) {
            this.next = next;
            this.val = val;
        }
        ListNode next;
        int val;
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode cur, next, memNext = null;

        cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = memNext;
            memNext = cur;
            cur = next;
        }

        return memNext;
    }
}
