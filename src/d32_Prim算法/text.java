package d32_Prim算法;

import d26_图.Graph;

public class text {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        int verxs = data.length;

        //邻接矩阵用二维数组表示 10000表示两个点不连通
        int[][] weight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };

        //创建MGraph和minTree
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();

        minTree.creatGraph(graph, verxs, data, weight);
        //minTree.showGraph(graph);
        minTree.prim(graph,0);
    }
}
