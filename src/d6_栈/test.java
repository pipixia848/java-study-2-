package d6_栈;

public class test {
    public static void main(String[] args) {
        ArrayStack a = new ArrayStack(5);

        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);

        a.pop();

        a.show();
    }
}
