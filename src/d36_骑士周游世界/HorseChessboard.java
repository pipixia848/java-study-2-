package d36_骑士周游世界;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {

    private static int X;//表示棋盘的列
    private static int Y;//棋盘的行
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean[] visited;
    //使用一个属性，交际是否棋盘的所有位置都被访问过
    private static boolean finished;

    public static void main(String[] args) {

        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[ X * Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row-1, column -1, 1);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        for (int[] rows : chessboard){
            for (int step : rows){
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }

    /**
     * @param chessboard 棋盘
     * @param row 马当前位置的行 从0开始
     * @param column 马当前位置的列 从0开始
     * @param step 第几步，初始为1
     */
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step){

        chessboard[row][column] = step;
        visited[row * X + column] = true;//标记该位置已访问
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);

        //遍历ps
        while(!ps.isEmpty()){
            Point p = ps.remove(0);
            if(!visited[p.y * X + p.x]){
                traversalChessboard(chessboard, p.y, p.x, step+1);
            }
        }

        //回溯过程
        if(step < X * Y && !finished){
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint){
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<>();
        //创建一个Point
        Point p1 = new Point();

        //判断马能够走几个位置，使用8个if语句
        if((p1.x = curPoint.x -2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x -1) >= 0 && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y){
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y){
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}
