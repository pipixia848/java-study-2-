package d30_KMP算法;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";


        //System.out.println(Arrays.toString(kmpNext(str2)));
        int[] next = kmpNext(str2);
        System.out.println(kmpSearch(str1, str2, next));
    }


    public static int kmpSearch(String str1, String str2, int[] next){

        for (int i = 0, j = 0; i < str1.length(); i++) {

            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取到一个字符串的部分匹配值表
    public static int[] kmpNext(String dest){

        int[] next = new int[dest.length()];
        next[0] = 0;

        for(int i = 1, j = 0; i < dest.length(); i++){

            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
//当p[i]和p[j]不相等的时候，需要去回溯
// p0至pj-1的子串，就是把这段看成一个单
// 独的子串，next[j-1]就是最长相同子串中前缀下一位的索引，
//