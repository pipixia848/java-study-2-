package d20_线索化二叉树;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);

        //对左子节点遍历
        if(this.left != null){
            this.left.preOrder();
        }

        //对右子节点遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        //左子树
        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        //右子树
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){

        if(this.left != null){
            this.left.postOrder();
        }

        if(this.right != null){
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //前序查找
    public HeroNode preOrderFind(int no){


        if(this.no == no){
            return this;
        }
        //开始遍历
        //左字节点查找，
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderFind(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.right != null){
            resNode = this.right.preOrderFind(no);
        }

        //都没有找到，返回NULL
        return resNode;
    }

    //中序
    public HeroNode infixOrderFind(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderFind(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.no == no){
            return this;
        }

        if(this.right != null){
            resNode = this.right.infixOrderFind(no);
        }

        return resNode;
    }

    //后序
    public HeroNode postOrderFind(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderFind(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.right != null){
            resNode = this.right.postOrderFind(no);
        }

        if(this.no == no){
            return this;
        }

        return resNode;
    }

    //递归删除节点
    public void delNode(int no){

        //先判断左子节点
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        //对左子树递归
        if(this.left != null){
            this.left.delNode(no);
        }

        if(this.right != null){
            this.right.delNode(no);
        }
    }
}
