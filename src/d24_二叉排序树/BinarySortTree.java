package d24_二叉排序树;

public class BinarySortTree {
    private Node root;

    //查找要删除的节点
    public Node search(int value){
        if(root ==null){
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value){
        if(root == null){
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     *
     * @param node 传入的节点（当作二叉排序树的根节点）
     * @return 返回最小节点
     */
    public int delRightTreeMin(Node node){
        Node target = node;

        while(target.left != null){
            target = target.left;
        }
        //这时target就指向了最小节点，删除这个节点
        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value){
        if(root == null){
            return;
        } else{
            //1.先找到要删除的节点targetNode
            Node targetNode = search(value);
            //若没找到
            if(targetNode == null){
                return;
            }
            //2.找到要删除节点的父节点
            Node parent = searchParent(value);

            //第一种情况 自生为叶子节点
            if(targetNode.left == null && targetNode.right == null){
                //判断是左子节点还是右子节点
                if(parent.left != null && parent.left.value == value){
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if(targetNode.left != null && targetNode.right != null){
                //第三种情况，有两颗子树
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                //第二种情况，删除只有一颗子树的节点
                if(targetNode.left != null){
                    if(parent.left.value == value){
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    if(parent.left.value == value){
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }

    //添加节点的方法
    public void add(Node node){
        if(root == null){
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }
    }

}
