package d29_动态规划;

import java.util.Arrays;

public class text {
    public static void main(String[] args) {

        int[] w = {1, 4, 3}; //商品的重量
        int[] val = {1500, 3000, 2000};
        int m = 4; //背包的容量
        int n = val.length; //物品的个数

        //创建二维数组
        int[][] v = new int[n+1][m+1];

        //初始化第一行和第一列 可省略
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //根据公式动态规划得到
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++){
                if(w[i - 1] > j){
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                }
            }
        }

        //输出
        for (int i = 0; i < v.length; i++) {
            System.out.println(Arrays.toString(v[i]));
        }
    }
}
