package d9_迷宫问题;

public class test {
    public static void main(String[] args) {
        //创建一个二维数组，用来模拟迷宫
        int[][] map = new int[8][7];

        //使用1表示墙，上下左右都为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //遍历map
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");
        setWay(map,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归给小球找路
    //找路策略 下，右 上 左
    public static boolean setWay(int[][] map, int i, int j){
        //先假设已经找到了
        if(map[6][5] == 2){
            return true;
        } else {
            if(map[i][j] == 0){ //假设这个点还没走过
                map[i][j] = 2;

                if(setWay(map, i + 1, j)){//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if(setWay(map, i, j - 1)){
                    return true;
                } else{
                    //说明该点是走不通的
                    map[i][j] = 3;
                    return false;
                }
            } else { //map i j 不等于0，可能为 1 2 3
                return false;
            }
        }
    }
}
