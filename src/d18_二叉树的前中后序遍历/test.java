package d18_二叉树的前中后序遍历;

import d20_线索化二叉树.HeroNode;

public class test {
    public static void main(String[] args) {
        //先创建一棵二叉树
        BinaryTree binaryTree = new BinaryTree();

        //需要创建的节点
        HeroNode root = new HeroNode(1,"a");
        HeroNode node2 = new HeroNode(2,"b");
        HeroNode node3 = new HeroNode(3,"c");
        HeroNode node4 = new HeroNode(4,"d");
        HeroNode node5 = new HeroNode(5,"e");
        //HeroNode node6 = new HeroNode(6,"e");
        //HeroNode node7 = new HeroNode(7,"e");

        //手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //node2.setLeft(node6);
        //node2.setRight(node7);

        //将节点信息传给BinaryTree
        binaryTree.setRoot(root);


        binaryTree.preOrder();
        System.out.println("---------------");
//        binaryTree.infixOrder();
//        System.out.println("--------------");
//        binaryTree.postOrder();

        //System.out.println(binaryTree.preOrderFind(6));

        binaryTree.delNo(3);
        binaryTree.preOrder();


    }
}
