package d4_双向链表;

import d3_单链表.HeroNode;

public class test {
    public static void main(String[] args) {

        HeroNode2 n1 = new HeroNode2(1,"1","1");
        HeroNode2 n2 = new HeroNode2(2,"2","2");
        HeroNode2 n3 = new HeroNode2(3,"3","3");
        HeroNode2 n4 = new HeroNode2(4,"4","4");

        DoubleLinkedList s = new DoubleLinkedList();

        s.add(n1);
        s.add(n2);
        s.add(n3);
        s.add(n4);

        s.show();

        System.out.println("---------------");

        s.Delete(4);
        s.Delete(2);

        s.addInOrder(n4);

        s.show();

    }
}
