package d12_插入排序;

public class test {
    public static void main(String[] args) {

        int[] arr = {12,4,9,3,7};
        insertSort(arr);


    }

    public static void insertSort(int[] arr){
        //运用两层循环
        for (int i = 1; i < arr.length; i++) {
            //定义两个变量，用来记录值和索引insert
            int insertVal = arr[i];
            int insertIndex = i - 1;

            /**
             *  给insertVal找到插入的位置
             *  insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
             */
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }

    }
}
