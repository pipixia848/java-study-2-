package d8_逆波兰表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);

        System.out.println(list);

        System.out.println("-------------------");
        List<String> l1 = parseSuffixExpressionList(list);
        System.out.println(l1);
        System.out.println(calculate(l1));

//        //先定义逆波兰表达式
//        String suffixExpression = "3 4 + 5 * 6 - ";
//
//        //将suffixExpression放到ArrayList中
//
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println(rpnList);
//
//        int res = calculate(rpnList);
//        System.out.println(res);
    }

    //将中缀表达式转成List
    public static List<String> toInfixExpressionList(String s){
        //定义一个list 存放中缀表达式对应的内容
        List<String> ls= new ArrayList<>();

        int i = 0; // 指针，用于遍历s
        String str; //用于多位数的拼接
        char c; //每遍历到一个字符，就放入c

        do{
            //不是数字
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while(i < s.length());
        return ls;
    }

    public static List<String> getListString(String suffixExpression){
        //将字符串进行分割
        List<String> list = new ArrayList<>();
        String[] split = suffixExpression.split(" ");
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            //为数
            if(item.matches("\\d+")){
                stack.push(item);
            } else {
                //为符号
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int rs = 0;
                if(item.equals("+")){
                    rs = num1 + num2;
                } else if (item.equals("-")) {
                    rs = num1 - num2;
                } else if (item.equals("*")) {
                    rs = num1 * num2;
                } else if(item.equals("/")){
                    rs = num1 / num2;
                } else {
                    throw new RuntimeException("符号错误~~");
                }

                //把rs入栈
                stack.push(rs + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //将中缀表达式转成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义一个栈和一个集合 第二个栈没有pop操作，用集合更方便
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        //使用增强for遍历传进来的ls
        for (String item : ls) {

            //1.若是一个数，则加入到s2中
            if(item.matches("\\d+")){
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //若是） 则一次弹出s1栈顶的运算符，并压入s2，知道遇到（为止，并将括号丢弃
                while(!(s1.peek().equals("("))){
                    s2.add(s1.pop());
                }
                //将（删除
                s1.pop();
            } else{
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //循环结束后，将item入s1
                s1.push(item);
            }

        }

        //将s1中的元素加入到s2中
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

}
