package d25_AVL树;

public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //返回左子树的高度
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    //返回右子树高度
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    //返回以该节点为根节点的树的高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    //查找要删除的节点
    public Node search(int value){
        if(value == this.value){
            return this;
        } else if (value < this.value) {
            if(this.left == null){
                return null;
            }
            return this.left.search(value);
        } else{
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }

    }

    //查找要删除节点的父节点
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value)||
        (this.right != null && this.right.value == value)){
            return this;
        } else {
            //如果查找的值小于当前节点的值，且当前节点的左子节点不为空
            if(this.value > value && this.left != null){
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null; //没找到父节点
            }
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){

        if(node == null){
            return;
        }

        if(node.value < this.value){ //放到左子树
            if(this.left == null){
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else  { //放到右子树
            if(this.right == null){
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //添加完节点后，若右高-左高 > 1
        if(rightHeight() - leftHeight() > 1){
            //若它的右子树的左子树高度大于它的右子树的右子树的高
            if(right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        if(leftHeight() - rightHeight() > 1){
            //若它的左子树的右子树高度大于它的左子树的高度
            if(left != null && left.rightHeight() > left.leftHeight()){
                //先对当前节点的左节点左旋转
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();

            }
        }
    }

    //中序遍历
    public void infixOrder(){

        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //左旋转
    private void leftRotate(){
        //创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        //把新节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新节点的右子树设置成带你过去的右子树的左子树
        newNode.right = right.left;
        // 把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }

    //右旋转
    private void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}
