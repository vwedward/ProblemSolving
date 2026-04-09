/*
 * ©Edward, 2021
 */

package ru.edward.leetcode;

import java.math.BigInteger;

/**
 * Problem 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */
public class L00002M_AddTwoNumbers {
    //Элемент списка
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Решение с помощью BigInteger
    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        StringBuilder val1 = new StringBuilder();
        StringBuilder val2 = new StringBuilder();
        ListNode curNode;

        curNode = l1;
        do {
            val1.insert(0, curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        curNode = l2;
        do {
            val2.insert(0, curNode.val);
            curNode = curNode.next;
        }
        while (curNode != null);

        BigInteger a = new BigInteger(val1.toString());
        BigInteger b = new BigInteger(val2.toString());
        BigInteger result = a.add(b);

        String sumStr = result.toString();

        curNode = null;
        for (int i = 0; i < sumStr.length(); i++) {
            //Первый элемент
            int val = Integer.parseInt(sumStr.substring(i, i + 1));
            //int val = sumStr.charAt(i) - '0'; -- как вариант
            if (curNode == null) {
                curNode = new ListNode(val);
            } else {
                curNode = new ListNode(val, curNode);
            }
        }
        return curNode;
    }

    //Решение "конвейером" (самое быстрое)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr;
        ListNode prevLr = null;
        ListNode result = null;
        int m = 0;

        do {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + m;

            lr = new ListNode(sum < 10 ? sum : sum - 10);
            if (prevLr == null) result = lr;
            else prevLr.next = lr;

            m = sum < 10 ? 0 : 1;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            prevLr = lr;
        }
        while (l1 != null || l2 != null);

        if (m == 1) {
            lr.next = new ListNode(1);
        }

        return result;
    }
}
