package d24_二叉排序树;

public class test {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};
        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixOrder();

        binarySortTree.delNode(7);

        System.out.println("================");
        binarySortTree.infixOrder();

    }
}
