package d2_使用数组模拟队列;

public class ArrayQueue {
    private int MaxSize;
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr;

    //创建一个构造器
    public ArrayQueue(int maxSize) {
        MaxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == MaxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    //往队列中添加数据
    public void add(int n){
        //拦截
        if(isFull()){
            System.out.println("队列满了");
            return;
        }

        rear++;
        arr[rear] = n;
    }

    //在队列中取数据
    public int get(){
        //拦截
        if(isEmpty()){
            //System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }

        front++;
        return arr[front];
    }

    //打印
    public void show(){
        if(isEmpty()){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(i>front) {
                System.out.println(arr[i]);
            }
        }
    }
}
