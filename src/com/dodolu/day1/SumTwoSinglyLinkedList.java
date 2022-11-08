package com.dodolu.day1;


/**
 * 给定两个单链表，链表的每个结点代表一位数，计算两个数之和。
 * 例如，输入链表（3→1→5）和链表（5→9→2），输出：8→0→8，即513+295=808，注意个位数在立链表头。
 *
 */
public class SumTwoSinglyLinkedList {
    // 实现思路简述 对链表中的结点直接进行相加操作，把相加的和存储在新的链表中对应的结点中，同时还要记录结点相加后的进位。

    // （1）每组结点进行相加后需要记录其是否有进位
    //
    //（2）如果两个链表H1和 H2的长度不同（长度分别为L1和L2，且L1<L2），当对链表的第L1位计算完成后，接下来只需要考虑链表L2剩余的结点的值（需要考虑进位）
    //
    //（3）对链表所有结点都完成计算后，还需要考虑此时是否还有进位，如果有进位，则需要增加新的结点，此结点的数据域为1
    static class LNode {
        /**
         * 数据域
         */
        int data;
        /**
         * 下一个结点的引用
         */
        LNode next;
    }
    public static LNode add(LNode h1,LNode h2){
        if(h1==null || h1.next==null){
            return h2;
        }
        if(h2==null || h2.next==null){
            return h1;
        }
        //用来记录进位
        int c = 0;
        //用来记录两个结点相加的值
        int sum = 0;
        //用来遍历h1
        LNode p1 = h1.next;
        //用来遍历h2
        LNode p2 = h2.next;
        //用来指向新创建的存储相加和的结点
        LNode tmp =null;
        //相加后链表头结点
        LNode resultHead = new LNode();
        resultHead.next = null;
        //用来指向链表resultHead最后一个结点
        LNode p =resultHead;
        while(p1 != null && p2 !=null){
            tmp = new LNode();
            tmp.next = null;
            sum = p1.data+p2.data+c;
            //两结点相加和
            tmp.data = sum%10;
            //进位
            c = sum/10;
            p.next = tmp;
            p = tmp;
            p1 = p1.next;
            p2 = p2.next;
        }
        //链表h2比h1长，接下来只需要考虑h2剩余结点的值
        if(p1==null){
            while(p2!=null){
                tmp = new LNode();
                tmp.next = null;
                sum = p2.data + c;
                tmp.data=sum%10;
                c = sum/10;
                p.next = tmp;
                p = tmp;
                p2 = p2.next;
            }
        }
        //链表h1比h2长，接下来只需要考虑h2剩余结点的值
        if(p2==null){
            while(p1!=null){
                tmp = new LNode();
                tmp.next = null;
                sum = p1.data + c;
                tmp.data=sum%10;
                c = sum/10;
                p.next = tmp;
                p = tmp;
                p1 = p1.next;
            }
        }
        //如果计算完成后还有进位，则增加新的结点
        if(c==1){
            tmp = new LNode();
            tmp.next = null;
            tmp.data = 1;
            p.next = tmp;
        }
        return resultHead;
    }

    public static void main(String[] args){
        int i =1;
        LNode head1 = new LNode();
        head1.next = null;
        LNode head2 = new LNode();
        head2.next = null;
        LNode tmp = null;
        LNode cur = head1;
        LNode addResult = null;
        //构造第一个链表
        for(;i<7;i++){
            tmp = new LNode();
            tmp.data = i+2;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        cur = head2;
        //构造第二个链表
        for(i=9;i>4;i--){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.print("Head1: ");
        for(cur=head1.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        System.out.print("\nHead2: ");
        for(cur=head2.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        addResult = add(head1,head2);
        System.out.print("\n相加后：");
        for(cur=addResult.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
    }


}
