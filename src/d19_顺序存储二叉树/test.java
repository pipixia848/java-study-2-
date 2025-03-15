package d19_顺序存储二叉树;

public class test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree a = new ArrBinaryTree(arr);
        a.preOrder(0);
    }
}
