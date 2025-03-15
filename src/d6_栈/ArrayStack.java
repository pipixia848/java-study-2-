package d6_栈;

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top-1 == maxSize;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈（push）
    public void push(int num){
        if(isFull()){
            System.out.println("栈满~~");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈 （pop）
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    //遍历栈
    public void show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }
}
