package d34_迪杰斯特拉算法;

import java.util.Arrays;

public class VisitedVertex {
    //记录各顶点是否访问过
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标
    public int[] pre_visited;
    //记录出发顶点到其他各顶点的距离
    public int[] dis;

    //构造器
    public VisitedVertex(int length, int index){
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];

        //初始化dis数组
        Arrays.fill(dis, 990);
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }

    //判断index顶点是否被访问过
    public boolean in(int index){
        return already_arr[index] == 1;
    }

    //更新出发顶点到index顶点的距离
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    //更新顶点的前驱为index节点
    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }

    //返回出发顶点到index顶点的距离
    public int getDis(int index){
        return dis[index];
    }

    //
    public int updateArr(){
        int min = 990, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点访问过
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    public void show(){
        System.out.println("===========");

        for(int i : already_arr){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : pre_visited){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : dis){
            System.out.print(i + " ");
        }
    }
}
