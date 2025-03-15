package d3_单链表;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1,"1","1");
        HeroNode n2 = new HeroNode(2,"2","2");
        HeroNode n3 = new HeroNode(3,"3","3");
        HeroNode n4 = new HeroNode(4,"4","4");
        HeroNode n5 = new HeroNode(2,"5","5");

        SingleLinkedList s = new SingleLinkedList();


        s.addInOrder(n1);
        s.addInOrder(n4);
        s.addInOrder(n2);
        s.addInOrder(n3);

//        System.out.println(getLength(SingleLinkedList.getHead()));
//
//        HeroNode res = findLastIndex(SingleLinkedList.getHead(),1);
//
//        System.out.println(res);

        //s.Delete(1);
        //s.upDate(n5);



        s.show();
        System.out.println("-------------");

        Print(SingleLinkedList.getHead());





    }
    //获取单链表中的节点个数
    public static int getLength(HeroNode head){
        if(head == null){
            return 0;//空链表
        }

        int length = 0;
        //创建一个临时变量
        HeroNode temp = head.next;

        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;

    }

    //获取单链表中倒数第几个元素
    public static HeroNode findLastIndex(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        int length = getLength(head);
        HeroNode temp = head.next;
        int a = 0;

        //进行index校验
        if(index <=0 || index > length){
            return null;
        }


        while(true){
            if(a == length - index){
                return temp;
            }else{
                temp = temp.next;
                a++;
            }

        }


     }

     //单链表的反转
    public static void reverseList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return; //判断单链表是否为空或只有一个数据
        }

        //定义一个辅助指针
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode ReverseHead = new HeroNode(0,"","");

        //进行反转
        while(cur !=null){
            next = cur.next;
            cur.next = ReverseHead.next;//将cur的下一个节点指向新链表的最前端
            ReverseHead.next = cur;//将cur链接到新的链表上
            cur = next;
        }
        head.next = ReverseHead.next;

    }

    //将单链表反转打印
    public static void Print(HeroNode head){
        Stack<HeroNode> s1 = new Stack<>();
        HeroNode temp = head.next;

        while(temp != null){
            s1.push(temp);
            temp = temp.next;
        }

        //入栈完成，出栈，打印
        while(!s1.isEmpty()){
            System.out.println(s1.pop());
        }
    }
}
