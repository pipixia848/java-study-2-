package d2_使用数组模拟队列;

public class test {
    public static void main(String[] args) {
        ArrayQueue a = new ArrayQueue(5);

        a.add(10);
        a.add(9);
        a.add(8);
        a.add(7);

        a.get();

        a.show();
    }
}
