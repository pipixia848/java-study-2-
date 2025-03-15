package d4_双向链表;

import d3_单链表.HeroNode;

public class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个节点
    public HeroNode2 pre; //指向前一个节点

    //构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }



    //重写toString方法


    @Override
    public String toString() {
        return "HeroNode{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
