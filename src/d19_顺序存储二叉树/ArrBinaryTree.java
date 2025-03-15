package d19_顺序存储二叉树;

public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法，完成顺序存储二叉数的前序遍历
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空~~");
        }
        //输出当前这个元素
        System.out.println(arr[index]);

        //进行左递归
        //防止索引越界
        if((index * 2 + 1) < arr.length){
            preOrder(index * 2 + 1);
        }

        if((index * 2 + 2) <arr.length){
            preOrder(index * 2 + 2);
        }

    }
}
