package d1_稀疏数组;

import java.io.*;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws Exception {
        //1.创建一个二维数组
        int[][] arr = {{0,0,1},{2,0,0},{1,0,0}};

        //2.将二维数组转成稀疏数组
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if(arr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        int[][] arr2 = new int[sum + 1][3];

        //3.将值传入稀疏数组
        arr2[0][0] = arr.length;
        arr2[0][1] = 3;
        arr2[0][2] = sum;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if(arr[i][j] != 0){
                    arr2[i+1] = new int[]{i, j, arr[i][j]};
                }
            }
        }


        //3.遍历稀疏数组
        for (int i = 0; i < arr2.length; i++) {
            for (int p = 0; p < arr2[0].length; p++) {
                System.out.print(arr2[i][p]);
            }
            System.out.println();
        }

        System.out.println("----------------------------");

        //将稀疏数组转成二维数组
        int[][] arr3 = new int[sum][3];

//        for (int i = 0; i < arr3.length; i++) {
//            for (int p = 0; p < arr3[0].length; p++) {
//                arr3[i][p] = 0;
//            }
//        }

        //遍历稀疏数组
        for (int i = 1; i < arr2.length; i++) {

                arr3[i-1][arr2[i][1]] = arr2[i][2];

        }

        //遍历还原后的数组
        for (int i = 0; i < arr3.length; i++) {
            for (int p = 0; p < arr3[0].length; p++) {
                System.out.print(arr3[i][p]);
            }
            System.out.println();
        }

        //使用io流将数据写入文件中
        try (
                PrintStream ps = new PrintStream("C:\\Users\\宁夏夏\\Desktop\\p10\\aaa.txt");
                ){
            ps.println(Arrays.toString(arr2[0]));
            ps.println(Arrays.toString(arr2[1]));
            ps.println(Arrays.toString(arr2[2]));



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //读取
            Reader r = new FileReader("C:\\Users\\宁夏夏\\Desktop\\p10\\aaa.txt");
            //InputStream bis = new BufferedInputStream(os);

        System.out.println(r.read());


    }
}
