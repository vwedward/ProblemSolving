/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест решения задачи №2
 * https://leetcode.com/problems/add-two-numbers/
 */
class Solution00002Test {

    @Test
    void addTwoNumbers() {
        //[2,4,3]
        Solution00002.ListNode curNode1;
        curNode1 = new Solution00002.ListNode(3);
        curNode1 = new Solution00002.ListNode(4, curNode1);
        curNode1 = new Solution00002.ListNode(2, curNode1);
        //[5,6,4]
        Solution00002.ListNode curNode2;
        curNode2 = new Solution00002.ListNode(4);
        curNode2 = new Solution00002.ListNode(6, curNode2);
        curNode2 = new Solution00002.ListNode(5, curNode2);

        Solution00002.ListNode resNode = Solution00002.addTwoNumbers(curNode1, curNode2);

        //[7,0,8] 342 + 465 = 807
        assertEquals(7, resNode.val);
        resNode = resNode.next;
        assertEquals(0, resNode.val);
        resNode = resNode.next;
        assertEquals(8, resNode.val);
    }
}