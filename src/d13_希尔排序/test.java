package d13_希尔排序;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        int[] arr = {8,7,3,5,6,2,1,0,4,9};

        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){

        for(int gep = arr.length/2; gep > 0;gep/=2){
            for (int i = gep; i < arr.length; i++) {
                //将步长为5的元素分为5组
                for (int j = i-gep; j >= 0; j-=gep) {
                    if(arr[j] > arr[j+gep]){
                        int temp = arr[j];
                        arr[j] = arr[j+gep];
                        arr[j+gep] = temp;
                    }
                }
            }
        }



//        //第一次排序
//        for (int i = 5; i < arr.length; i++) {
//            //将步长为5的元素分为5组
//            for (int j = i-5; j >= 0; j-=5) {
//                if(arr[j] > arr[j+5]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        for (int i = 2; i < arr.length; i++) {
//            //将步长为5的元素分为5组
//            for (int j = i-2; j >= 0; j-=2) {
//                if(arr[j] > arr[j+2]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

    }
}
