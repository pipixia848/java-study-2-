package d11_选择排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class test {
    public static void main(String[] args) {

//        int[] arr = {4,5,1,3};
//        selectSort(arr);
//
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[160000];
        for (int i = 0; i < 160000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        //计算时间
        Date d1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(d1);
        System.out.println("前："+date1);

        selectSort(arr);
        Date d2 = new Date();
        String date2 = simpleDateFormat.format(d2);
        System.out.println("后："+date2);
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            //值交换
            if(index != i) {
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
    }
}
