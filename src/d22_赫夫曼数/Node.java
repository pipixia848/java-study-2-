package d22_赫夫曼数;

public class Node implements Comparable<Node>{

    int value; //节点权值
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //实现Comparable接口，用来排序 升序
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    //一个前序遍历
    public void preOrder(){
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}
