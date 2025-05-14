package d34_迪杰斯特拉算法;

import java.util.Arrays;

public class Graph {
    private char[] vertex; //顶点数组
    private int[][] matrix;//领接矩阵
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showGraph(){
        for(int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    public void showD(){
        vv.show();
    }

    //实现
    public void dsj(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index);

        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();
            update(index);
        }

    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
    private void update(int index){
        int len = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            //len：出发顶点的距离+从index顶点到j顶点的距离之和
            len = vv.getDis(index) + matrix[index][j];
            //j未被访问， 且len小于出发顶点到j顶点的距离之和
            if(!vv.in(j) && len < vv.getDis(j)){
                vv.updatePre(j, index);
                vv.updateDis(j, len);
            }
        }
    }
}
