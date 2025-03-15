package d4_双向链表;

import d3_单链表.HeroNode;

public class DoubleLinkedList {
    //初始化一个头节点
    private HeroNode2 head = new HeroNode2(0,"","");


    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }

    //添加
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;

        while(true){
            if(temp.next == null){
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }
            temp = temp.next;
        }

    }

    //修改节点的信息，根据no编号来修改
    public void upDate(HeroNode2 newHeroNode){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空~~");
            return;
        }

        //找到要修改的节点 遍历
        while(true){
            if(head.next.no == newHeroNode.no){
                head.next.name = newHeroNode.name;
                head.next.nickname = newHeroNode.nickname;
                break;
            }
            head = head.next;
        }

    }

    //删除
    public void Delete(int n){
        HeroNode2 temp = head.next;
        boolean flag = true;
        //遍历链表
        while(true){
            if(temp.no == n){
                temp.pre.next = temp.next;
                if( !(temp.next == null)){
                    temp.next.pre = temp.pre;
                }
                flag = false;
                break;
            }
            if(temp == null){
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.println("没找到~~~");
        }
    }

    //遍历链表
    public void show(){
        //首先判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空~~");
            return;
        }

        //进行遍历
        HeroNode2 temp = head.next;
        while(true){
            //若为最后一个元素，则结束
            if(temp == null){
                break;
            }
            System.out.println(temp);
            //后移
            temp = temp.next;
        }


    }

    //根据排名添加数据
    public void addInOrder(HeroNode2 heroNode) {
        //创建一个临时变量
        HeroNode2 temp = head;
        boolean flag = false; //用来判断是否有相同编号的节点

        //进行遍历
        while (true) {
            if (temp.next == null) {
                break;
            }
            //找到
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag){
            System.out.println("已经存在编号相同的节点~~");
            return;
        }else {
            heroNode.pre = temp;
            heroNode.next = temp.next;
            if(temp.next == null){
                temp.next = heroNode;
                return;
            }else {
                temp.next.pre = heroNode;
            }



        }
    }

}
