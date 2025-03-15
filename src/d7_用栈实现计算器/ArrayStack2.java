package d7_用栈实现计算器;


public class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
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

    //返回运算符的优先级，优先级越高，返回的数字越大
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else{
            return -1;
        }
    }

    //判断是否是一个运算符
    public boolean isOper(char val){
        return val == '+'||val == '-'||val == '*'||val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

    //可以返回当前栈顶的值
    public int peek(){
        return stack[top];
    }
}
