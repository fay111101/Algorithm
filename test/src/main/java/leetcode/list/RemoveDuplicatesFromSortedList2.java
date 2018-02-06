package leetcode.list;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = preHead;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                //pre在没有赋值之前操作的是伪头指针节点，在赋值了之后操作的是cur的pre节点
                pre = pre.next;

            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return preHead.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                if (fast == null) {
                    pre.next = null;
                }
                flag = true;
            } else {

                if (flag) {
                    if (pre == null) {
                        head = fast;
                    } else {
                        pre.next = fast;
                    }
                    flag = false;
                } else {
                    pre = slow;
                }

                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplication2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int value = cur.val;
                while (cur.next != null && cur.next.val == value) {
                    cur = cur.next;
                }
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode insertT(ListNode head, int data) {
        ListNode n = new ListNode(data);
        n.next = head;
        head = n;
        return head;
    }

    public ListNode insertH(ListNode head, int data) {
        ListNode n = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            n.next = null;//n.next=head
            head = n;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = n;
        }
        return head;
    }

    public void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 test = new
                RemoveDuplicatesFromSortedList2();
        ListNode head = null;
        int[] data = {2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 7, 7, 8};
        for (int i : data) {
            head = test.insertH(head, i);
        }
        test.display(head);
        System.out.println("====");
        head = test.deleteDuplicates1(head);
        test.display(head);

    }
}
