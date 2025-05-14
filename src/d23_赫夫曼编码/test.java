package d23_赫夫曼编码;

import java.util.*;

public class test {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        // 压缩
        byte[] compressed = huffmanZip(contentBytes);
        System.out.println("压缩后: " + Arrays.toString(compressed));

        // 解压
        byte[] decompressed = decode(huffmanCodes, compressed);
        System.out.println("解压后: " + new String(decompressed));

        //将字符串转成Byte数组
        //byte[] contentBytes = content.getBytes();
        /*
        //System.out.println(contentBytes.length);

        List<Node> nodes = getNodes(contentBytes);

        //System.out.println(nodes);
        Node huffmanTreeRoot = createHuffmanTree(nodes);

        //huffmanTreeRoot.preOrder();
        preOrder(huffmanTreeRoot);

        //
        getCodes(huffmanTreeRoot);
        System.out.println(huffmanCodes);
        byte[] a = zip(contentBytes, huffmanCodes);
        System.out.println(Arrays.toString(a));

         */

        //byte[] a = huffmanZip(contentBytes);
        //System.out.println(Arrays.toString(a));

        //System.out.println(byteToBitString(true, (byte)-8));
       // byte[] sourceBytes = decode(huffmanCodes, a);

       // System.out.println(new String(sourceBytes));
    }

    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){

        StringBuilder stringBuilder = new StringBuilder();

        //将byte数组转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++){
            //判断是否是最后一个字节
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }

        //把字符床安装指定的赫夫曼编码进行解码
        Map<String, Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }

        //创建集合，存放byte
        List<Byte> list = new ArrayList<>();
        //i 可以理解成就是索引，扫描StringBuilder
        for(int i = 0; i < stringBuilder.length(); ){
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while(flag){
                //i 不动，让count移动，用于匹配字符
                String key = stringBuilder.substring(i, i+count);
                b = map.get(key);
                if(b == null){
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i +=count; //直接移动到count位置
        }

        //当for循环结束后，list集合里存放了所有字符
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     *
     * @param flag 标志是否需要补高位，true补，反之不补
     * @param b
     * @return
     */
    private static String byteToBitString(boolean flag, byte b){
        //使用变量保存b
        int temp = b;
        //如果是正数就补高位
        if(flag){
            temp |= 256; //按位与
        }

        String str = Integer.toBinaryString(temp);//返回的是temp对应的而二进制补码

        if(flag){
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    //将前面的方法封装，方便调用
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes，创建哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] a = zip(bytes, huffmanCodes);

        return a;
    }


    //将字符串对应的byte数组通过赫夫曼编码表，返回一个赫夫曼编码
    //压缩后的byte数组

    /**
     *
     * @param bytes 原始的byte数组
     * @param huffmanCodes 生成的赫夫曼编码表map
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
        //1，利用huffmanCodes将bytes转成赫夫曼对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //2，遍历byte数组
        for(byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println(stringBuilder.toString());

        //统计返回byte[] huffmanCodeBytes 长度
        int len = (stringBuilder.length() + 7)/8;

        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;

        for(int i = 0; i < stringBuilder.length(); i+=8){
            String strByte;
            if(i+8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            } else{
                strByte = stringBuilder.substring(i, i+8);
            }
            //将strByte转成一个byte，放到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;

    }


    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
    }

    private static Map<Byte, String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     *
     * @param bytes 接收一个字节数组
     * @return      返回一个list
     */
    private static List<Node> getNodes(byte[] bytes){

        //1.创建一个arraylist
        ArrayList<Node> nodes = new ArrayList<Node>();

        //
        HashMap<Byte, Integer> counts = new HashMap<>();
        for(byte b : bytes){
            Integer count  = counts.get(b);
            if(count == null){ //map还没有这个字符数据，第一次
                counts.put(b,1);
            } else {
                counts.put(b,count + 1);
            }
        }

        //把每一个键值对转成一个Node对象，并加入到nodes集合
        //遍历map
        for(Map.Entry<Byte, Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){

        while(nodes.size() > 1){
            //排序，从小到大
            Collections.sort(nodes);
            //取出最小和第二小的二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一棵新二叉树，根节点没有data，只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已经处理的两颗二叉树删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    //生成哈夫曼树对应的赫夫曼编码
    //1.将赫夫曼编码表放在Map<Byte, String>
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合中
     * @param node 传入节点
     * @param code 路径
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);

        if(node != null){ //若node==null 则不处理
            //判断node是不是叶子节点
            if(node.data == null){
                //递归
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);

            } else { // 是叶子节点
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }
}
