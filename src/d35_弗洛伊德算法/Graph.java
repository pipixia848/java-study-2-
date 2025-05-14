package d35_弗洛伊德算法;

import java.util.Arrays;

public class Graph {
    private char[] vertex;//存放顶点的数组
    private int[][] dis; //保存从各个顶点出发到其他顶点的距离
    private int[][] pre;//保存目标顶点的前驱顶点

    //构造器
    public Graph(int length, int[][] matrix, char[] vertex){
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        //对pre初始化
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    //显示pre和dis
    public void show(){

        char[] vertex = {'A','B','C','D','E','F','G'};

        for (int k = 0; k < dis.length; k++) {

            //显示pre的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(pre[k][i]+" ");
            }
            System.out.println();
            //显示dis的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(dis[k][i]+" ");
            }
            System.out.println();
            System.out.println();
        }
    }

    //算法实现
    public void floyd(){
        int len = 0;
        //中间顶点
        for (int k = 0; k < dis.length; k++) {
            //出发点
            for (int i = 0; i < dis.length; i++) {
                //终点
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    //更新
                    if(len < dis[i][j]){
                        dis[i][j] = len;
                        pre[i][j] = dis[k][j];
                    }
                }
            }
        }
    }

}
