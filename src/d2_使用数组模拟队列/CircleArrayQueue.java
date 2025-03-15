package d2_使用数组模拟队列;

public class CircleArrayQueue {
    private int MaxSize;
    private int front; //队列头
    private int rear; //队列尾部
    private int[] arr;

    public CircleArrayQueue(int maxSize){
        MaxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断是否满
    public boolean isFull(){
        return (rear + 1) % MaxSize == front;
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

        //直接将数据加入
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % MaxSize;
    }

    //在队列中取数据
    public int get(){
        //拦截
        if(isEmpty()){
            //System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }

        //分析front是指向第一个元素
        int value = arr[front];
        front = (front + 1) % MaxSize;
        return value;
    }

    //遍历
    public void show(){
        if(isEmpty()){
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("值：" + arr[i % MaxSize]);
        }

    }

    //求出队列有效数据的个数
    public int size(){
        return (rear + MaxSize - front) % MaxSize;
    }

}
