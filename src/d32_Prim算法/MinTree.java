package d32_Prim算法;

import java.util.Arrays;

public class MinTree {

    //创建图的邻接矩阵
    public void creatGraph(MGraph graph, int verxs,
                           char[] data, int[][] weight){
        int i,j;
        for(i = 0; i < verxs; i++){
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示
    public void showGraph(MGraph graph){
        for(int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     *
     * @param graph
     * @param v 表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v){

        //visited 标记节点是否被访问
        int[] visited = new int[graph.verxs];
        //把传入的v标记为已访问
        visited[v] = 1;

        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;

        for (int k = 1; k < graph.verxs; k++){

            for (int i = 0; i < graph.verxs; i++){
                for (int j = 0; j < graph.verxs; j++){
                    if(visited[i] == 1 && visited[j] == 0 &&
                    graph.weight[i][j] < minWeight){
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] +","
            +graph.data[h2]+"> 权值："+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}
