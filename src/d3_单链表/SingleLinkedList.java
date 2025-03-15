package d3_单链表;

public class SingleLinkedList {
    //创建头节点
    static HeroNode head = new HeroNode(0,"","");

    public static HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加数据
    public void add(HeroNode heronode){
        HeroNode temp = head;

        //遍历链表，找到最后
        while(true){
            //找到了最后
            if(temp.next == null){
                temp.next = heronode;
                break;
            }
            //后移
            temp = temp.next;
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
        HeroNode temp = head.next;
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
    public void addInOrder(HeroNode heroNode){
        //创建一个临时变量
        HeroNode temp = head;
        boolean flag = false; //用来判断是否有相同编号的节点

        //进行遍历
        while(true){
            if(temp.next == null){
                break;
            }
            //找到
            if(temp.next.no > heroNode.no){
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
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改
    public void upDate(HeroNode newHeroNode){
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

    //删除节点
    public void Delete(int num){
        //创建一个临时变量
        HeroNode temp = head;
        boolean flag = false;

        //遍历到要删除的节点的前一个节点
        while(true){
            if(temp.next == null){
                //没找到
                break;
            }
            if(temp.next.no == num){
                //找到了，删除
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
        }else{
            System.out.println("没找到~~");
        }

    }

    //temp.pre.next = temp.next;
    //temp.next.pre = temp.pre;



}
