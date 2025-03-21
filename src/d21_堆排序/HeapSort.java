package d21_堆排序;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //进行升序排列（大顶堆）
        int[] arr = {4,6,8,5,9};
        hearSort(arr);
    }

    public static void hearSort(int[] arr){

        int temp = 0;
        //将数组变成大顶堆
        for(int i = arr.length/2-1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
        //System.out.println(Arrays.toString(arr));

        for (int j = arr.length-1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));

    }

    //将一个数组（二叉树），调整成一个大顶堆
    /**
     *
     * @param arr 待调整的数组
     * @param i   表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];

        //开始调整
        //k = i*2+1 k是i的左子节点
        for(int k = i*2+1; k < length; k = k*2+1){

            if(k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if(temp < arr[k]){
                arr[i] = arr[k];
                i = k;
            } else{
                break;
            }
        }
        arr[i] = temp;
    }

}
