package d24_二叉排序树;

public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
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
}
