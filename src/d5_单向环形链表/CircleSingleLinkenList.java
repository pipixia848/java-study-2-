package d5_单向环形链表;

public class CircleSingleLinkenList {
    //创建一个first节点，当前没有编号
    private Boy first = null;

    //添加
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("数据不正确~~");
            return;
        }

        Boy curBoy = null;

        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩
            Boy boy = new Boy(i);

            if(i == 1){
                first = boy;
                first.setNext(first); //形成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy; //后移
            }


        }

    }

    //遍历当前环形链表
    public void show(){
        //判断是否为空
        if(first == null){
            System.out.println("链表为空~~");
            return;
        }

        //创建一个辅助指针
        Boy curBoy = first;

        while(true){
            System.out.println(curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有几个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums){
        //进行数据校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("输入的数据有误！！");
            return;
        }

        //创建辅助指针，帮助小孩出圈
        Boy helper = first;

        //让helper指向最后的节点
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //报数前，先让first，helper移动startNum-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //进行删除操作
        while(true){
            //当圈中只有一个人时，结束循环
            if(helper == first){
                break;
            }
            //让first helper指针同时移动countNo-1次，然后出圈
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩" + first.getNo() + "出圈" );
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println("最后的小孩编号是：" + first.getNo());
    }
}
