/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        
        int m = 0;
        int n = 0;
        ListNode ret = null;
        
        for (int i = 0; i < lists.length; i++) {
            ListNode p = lists[i];
            while (p != null) {
                if (p.val >= 0 && p.val > m) {
                    m = p.val;
                }
                if (p.val < 0 && (p.val * -1) > n) {
                    n = -1 * p.val;
                }
                p = p.next;
            }
        }
        int[] n_list = null;
        int[] new_list = new int[m + 1];
        if (n != 0) {
            n_list = new int[n + 1];
        }
        for (int i = 0; i < lists.length; i++) {
            ListNode p = lists[i];
            while (p != null) {
                if (p.val >= 0) {
                    new_list[p.val] += 1;
                    p = p.next;
                } else {
                    n_list[p.val * -1] += 1;
                    p = p.next;
                }
            }
        }
        
        ListNode p = ret;
        
        if (n != 0) {
            for (int q = n; q >= 0; q--) {
                while (n_list[q] != 0) {
                    if (ret == null) {
                        ret = new ListNode(-q);
                        p = ret;
                        n_list[q] -= 1;
                        continue;
                    }
                    p.next = new ListNode(-q);
                    p = p.next;
                    System.out.println(q);
                    n_list[q] -= 1;
                }
            }
        }
        
        for (int i = 0; i < new_list.length; i++) {
            
            
            while (new_list[i] != 0) {
                if (ret == null) {
                    ret = new ListNode(i);
                    p = ret;
                    new_list[i] -= 1;
                    continue;
                }
                p.next = new ListNode(i);
                p = p.next;
                new_list[i] -= 1;
            }
        }
        return ret;
    }
}
