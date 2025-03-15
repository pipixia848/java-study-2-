package d10_冒泡排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        //int[] arr = {3,9,-1,10,-2};

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000);
        }

        //计算时间
        Date d1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(d1);
        System.out.println("前："+date1);

        int[] arr2 = bubblingSorting(arr);
        Date d2 = new Date();
        String date2 = simpleDateFormat.format(d2);
        System.out.println("后："+date2);


        //System.out.println(Arrays.toString(arr2));

    }

    public static int[] bubblingSorting(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                flag = true;
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
        return arr;
    }
}
