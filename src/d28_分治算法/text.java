package d28_分治算法;

public class text {
    public static void main(String[] args) {

        hanoiTower(16,'A','B','C');
        System.out.println(count);

    }
    static int count = 0;
    public static void hanoiTower(int num, char a, char b, char c){

        if(num == 1){
            //count++;
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            hanoiTower(num -1, a, c, b);
            count++;
            //把最下面的盘从a->c
            System.out.println("第" + num +"个盘" + a + "->" + c);

            //把b的所有盘移动到c
            hanoiTower(num-1, b, a, c);
        }
    }
}

/*
汉罗塔的整体思路
1， 将第一个盘子从a 移动到c
2. 将最下边的一个盘子和上面的盘子分成两部分，将上面的盘子放到
b中
3.将最下面的盘子放到c
4.将上面的盘子从b移动到c
 */
