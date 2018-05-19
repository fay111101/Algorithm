package leetcode.list;

public class InsertionSortList {


    public ListNode insertionSortList(ListNode head) {

        if (head == null) return head;

        //i 当前排序的前结点 j当前排序结点  t当前比较结点 t_pre比较结点的前结点
        ListNode cur = head, p = head.next, n, npre;

        //排序结点不为空
        while (p != null) {

            //从前面往后 在排序结点前的结点已有序 查找值比排序结点大的结点 即插入点
            npre = null;
            n = head;
            while (n != p) {

                if (n.val > p.val) {

                    //找到插入点  改变相应指针的指向
                    cur.next = p.next;
                    p.next = n;

                    //判断插入点是否是头结点
                    if (npre != null) {
                        npre.next = p;
                    } else {
                        head = p;
                    }

//排序结点后移 前结点没变
                    p = cur.next;

                    break;

                }
                npre = n;
                n = n.next;

            }

//不需要插入 刚好是顺序 排序结点及其前结点后移
            if (n == p) {

                cur = p;
                p = p.next;

            }

        }

        return head;

    }


    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode p = cur.next;
        while (p != null) {
            ListNode n = head;
            if (p.val < cur.val && n != p) {
                ListNode npre = null;
                while (n != null && n != p) {
                    if (p.val < n.val) {
                        cur.next = p.next;
                        p.next = n;
                        if (npre != null) {
                            npre.next = p;
                        } else {
                            head = p;
                        }
                        p = cur.next;
                        break;
                    }
                    npre = n;
                    n = n.next;
                }
            } else {
                cur = p;
                p = p.next;
            }
        }
        return head;
    }

    public void swap(ListNode u, ListNode v) {
        int temp = u.val;
        u.val = v.val;
        v.val = temp;
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
        InsertionSortList test = new InsertionSortList();

        ListNode head = null;
        int[] data = {-5, 0, 1, 5, -2, -6};
        for (int i : data) {
            head = test.insertH(head, i);
        }

        //System.out.println("-----");
        test.display(head);
        head = test.insertionSortList1(head);
//        head = test.insertionSortList(head);
        System.out.println("-----");
        test.display(head);


    }


}
