package d2_使用数组模拟队列;

public class test2 {
    public static void main(String[] args) {
        CircleArrayQueue c = new CircleArrayQueue(4);

        c.add(1);
        c.add(2);
        c.add(3);
       // c.add(4);


        c.get();
        c.get();
        c.get();
        c.get();

        c.show();
    }
}
