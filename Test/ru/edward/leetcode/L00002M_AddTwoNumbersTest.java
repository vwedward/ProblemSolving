/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */
class L00002M_AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        //[2,4,3]
        L00002M_AddTwoNumbers.ListNode curNode1;
        curNode1 = new L00002M_AddTwoNumbers.ListNode(3);
        curNode1 = new L00002M_AddTwoNumbers.ListNode(4, curNode1);
        curNode1 = new L00002M_AddTwoNumbers.ListNode(2, curNode1);
        //[5,6,4]
        L00002M_AddTwoNumbers.ListNode curNode2;
        curNode2 = new L00002M_AddTwoNumbers.ListNode(4);
        curNode2 = new L00002M_AddTwoNumbers.ListNode(6, curNode2);
        curNode2 = new L00002M_AddTwoNumbers.ListNode(5, curNode2);

        L00002M_AddTwoNumbers.ListNode resNode = L00002M_AddTwoNumbers.addTwoNumbers_2(curNode1, curNode2);

        //[7,0,8] 342 + 465 = 807
        assertEquals(7, resNode.val);
        resNode = resNode.next;
        assertEquals(0, resNode.val);
        resNode = resNode.next;
        assertEquals(8, resNode.val);
    }
}