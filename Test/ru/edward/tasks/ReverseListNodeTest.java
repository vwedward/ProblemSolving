/*
 * ©Edward, 2021
 */

package ru.edward.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест решения задачи с собеседования Сулейманова
 * https://www.youtube.com/watch?v=d2d08macAH4&list=PLlsMRoVt5sTMMCwd_gLaaZMkQhzVh9hLA&index=8
 */
class ReverseListNodeTest {
    @Test
    void reverseListNode() {
        // 1 -> 2 -> 3 -> null
        // 3 -> 2 -> 1 -> null
        ReverseListNode.ListNode ln;
        ln = new ReverseListNode.ListNode(null, 3);
        ln = new ReverseListNode.ListNode(ln, 2);
        ln = new ReverseListNode.ListNode(ln, 1);

        ln = ReverseListNode.reverseListNode(ln);

        assertEquals(3, ln.val);
        ln = ln.next;
        assertEquals(2, ln.val);
        ln = ln.next;
        assertEquals(1, ln.val);
    }
}