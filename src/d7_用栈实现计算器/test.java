package d7_用栈实现计算器;

public class test {
    public static void main(String[] args) {
        //先写一个表达式
        String expression = "30+2*6-2";

        //创建两个栈，数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        //用循环扫描expression
        while(true){
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);

            //判断ch是什么，做相应的判断
            //1,为运算符
            if(operStack.isOper(ch)){
                //判断是否为空
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);

                        //把运算结果存入数栈
                        numStack.push(res);
                        //把当前符号入符号栈
                        operStack.push(ch);
                    } else {
                        //当前的符号优先级大于栈顶
                        operStack.push(ch);
                    }

                } else {
                    //如果为空，直接入符号栈
                    operStack.push(ch);
                }

            } else { //为数
                //numStack.push(ch - 48);
                //处理多位数
                keepNum += ch;

                //若keepNum是最后一位，就直接入栈
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if(operStack.isOper(expression.substring(index + 1,index + 2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum清空！！！！
                        keepNum = "";
                    }
                }
            }
            //让index + 1；并判断是否扫描到最后
            index++;

            if(index >= expression.length()){
                break;
            }
        }

        //当表达式扫描完时，顺序从栈中pop相应的数和符号，并运算
        while(true){
            //若符号栈为空，则结束
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);

            //把运算结果存入数栈
            numStack.push(res);
        }
        System.out.println("结果是：" + numStack.pop());
    }
}
