package d33_kruskal算法;

import java.util.Arrays;

public class text {

    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    //使用INF表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {

        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        text text = new text(vertexs, matrix);
        //text.print();

        //排序前
        EData[] edges = text.getEdges();
//        System.out.println(Arrays.toString(edges));
//       System.out.println(text.getEdges().length);
//
//        System.out.println();
//        text.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));

        text.kruskal();
    }

    //构造器
    public text(char[] vertexs, int[][] matrix){
        //初始化顶点和边
        int vlen = vertexs.length;

        this.vertexs = new char[vlen];
        for(int i = 0; i < vertexs.length; i++){
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if(this.matrix[i][j] != INF){
                    edgeNum++;
                }
            }
        }
    }

    //打印
    public void print(){
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%-12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sortEdges(EData[] edges){

        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if(edges[j].weight > edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    //返回对应的索引
    private int getPosition(char ch){
        for (int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过获取图中的边，放到EData[] 数组中
     * @return
     */
    private EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];

        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF ){
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标i的顶点的终点，用于判断两个顶点的终点是否相同
     * @param ends 记录各个顶点对应的终点是哪个，ends数组在遍历中逐步形成
     * @param i 表示传入顶点对应的下标
     * @return 下标为i这个顶点对应的终点的下标
     */
    private int getEnd(int[] ends, int i){
        while(ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

    public void kruskal(){
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];

        //获取所有边的集合
        EData[] edges = getEdges();

        //排序
        sortEdges(edges);

        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);

            if(m != n){
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        //打印最小生成树
        System.out.println("树"+Arrays.toString(rets));
    }
}
