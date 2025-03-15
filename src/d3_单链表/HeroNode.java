package d3_单链表;

public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点

    //构造器

    public HeroNode(int no, String name, String nickname) {
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
