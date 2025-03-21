package d22_赫夫曼数;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        //System.out.println(createHuffmanTree(arr));

        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    //写一个前序遍历方法
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
    }

    public static Node createHuffmanTree(int[] arr){

        //1,遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到Arraylist中

        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int value : arr){
            nodes.add(new Node(value));
        }



        while(nodes.size() > 1) {
            //排序 从小到大
            Collections.sort(nodes);

            //1.取出根节点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //2.创建一颗新的二叉树
            Node parent = new Node(rightNode.value + leftNode.value);
            parent.right = rightNode;
            parent.left = leftNode;

            //3.删除节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //4.把新节点添加到数组中
            nodes.add(parent);

        }
        return nodes.get(0);

        //System.out.println(nodes);

    }
}
