package d20_线索化二叉树;

public class ThreadBinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }

    //编写对二叉树进行中序线索化的方法
    public void threadNodes(HeroNode node){
        if(node == null){
            return;
        }
        //1,线索化左子树
        threadNodes(node.getLeft());

        //2.线索化当前节点
        if(node.getLeft() == null){
        }

        //3.线索化右子树
        threadNodes(node.getRight());
    }

    //前序
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }
    }

    //中序
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }
    }

    //后序
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }
    }

    //前中后序查找
    public HeroNode preOrderFind(int no){
        HeroNode resNode = null;
        if(this.root != null){
            resNode = this.root.preOrderFind(no);
        }
        return resNode;
    }

    public HeroNode infixOrderFind(int no){
        HeroNode resNode = null;
        if(this.root != null){
            resNode = this.root.infixOrderFind(no);
        }
        return resNode;
    }

    public HeroNode postOrderFind(int no){
        HeroNode resNode = null;
        if(this.root != null){
            resNode = this.root.postOrderFind(no);
        }
        return resNode;
    }

    //删除
    public void delNo(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~~");
        }
    }
}
