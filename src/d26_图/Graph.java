package d26_图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的领结矩阵
    private int numOfEdges; //表示边的数目
    //定义一个数组boolean，记录某个节点是否被访问
    private boolean[] isVisited;

    public Graph(char[] vertex, int[][] matrix) {
    }


    public static void main(String[] args) {

        int n = 5;
        String[] Vertexs = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        for (String vertex : Vertexs){
            graph.insertVertex(vertex);
        }

        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
        //graph.dfs();
        graph.bfs();
    }

    //构造器
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];

    }

    //得到第一个领接节点的下标
    public int getFirstNeightbor(int index){
        for (int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点的下标
    public int getNextNeightbor(int v1, int v2){
        for (int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited, int i){
        //首先访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将节点设置成已访问
        isVisited[i] = true;
        //查找节点i的邻接节点
        int w = getFirstNeightbor(i);
        while(w != -1){ //说明有
            if(!isVisited[w]){
                dfs(isVisited, w);
            }
            //若w节点已被访问
            w = getNextNeightbor(i, w);
        }
    }

    //对dfs重载
    public void dfs(){
        //遍历所有的节点，进行回溯
        for (int i = 0; i < getNumOfEdges(); i++){
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //对一个节点进行广度优先遍历
    private void bfs(boolean[] isVisited, int i){
        int u;// 表示队列的头节点对应的下标
        int w;  //邻接节点

        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        //访问节点，输出节点信息
        System.out.println(getValueByIndex(i) + "->");

        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);

        while(!queue.isEmpty()){
            //取出队列头节点的下标
            u = (Integer)queue.removeFirst();
            //得到第一个邻接节点的下标w
            w = getFirstNeightbor(u);

            while(w != -1){
                //是否访问过
                if(!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "->");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队列
                    queue.addLast(w);
                }
                //已u为前驱点，找w后面的下一个邻接点
                w = getNextNeightbor(u, w);
            }

        }
    }

    //遍历所有的节点，都进行广度优先搜索
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //显示矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回节点i（下标）对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
