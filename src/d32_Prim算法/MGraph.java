package d32_Prim算法;

public class MGraph {
    int verxs; //图的节点个数
    char[] data;//存放节点数据
    int[][] weight;//存放边，就是邻接矩阵

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
