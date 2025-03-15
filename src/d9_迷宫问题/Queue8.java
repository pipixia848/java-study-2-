package d9_迷宫问题;

public class Queue8 {

    //定义一个max和一个数组
    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 q = new Queue8();
        q.check(0);
        System.out.println(count);
    }

    //放置第n个皇后
    private void check(int n){
        if(n == max){
            print();
            return;
        }

        //依次放入皇后，看是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放在改行的第一列
            array[n] = i;
            //判断放置第n个皇后到i列是，是否冲突
            if(judge(n)){//不冲突
                //开始递归
                check(n+1);
            }
            //如果冲突，则放到下一列，即i++
        }
    }


    //查看当我们放置第n个皇后，就去检测皇后是否与前面的冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            // 1.array[i] == array[n] 判断第n个皇后是否与前面的皇后在同一列
            // 2.Math.abs(n-i) == Math.abs(array[n]-array[i])
            // 判断第n个皇后是否与第i皇后在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //用来打印皇后摆放的位置
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        count++;
    }

}
