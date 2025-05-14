package d31_贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class text {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();

        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map里
        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);

        //创建一个存放所有地区的集合
        HashSet<String> allAreas = new HashSet<>();

        for(HashSet set:broadcasts.values()){
            for(Object val:set){
                allAreas.add(new String(String.valueOf(val)));
            }
        }

        //创建一个集合，存放选择电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交际
        HashSet<String> tempSet = new HashSet<>();

        String maxKey = null;

        while(allAreas.size()!= 0){

            maxKey = null;

            for(String key:broadcasts.keySet()) {
                tempSet = new HashSet<>();

                //当前这个key可以覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);

                //求出tempSet与allareas的交集
                tempSet.retainAll(allAreas);

                if (tempSet.size() != 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
                if(maxKey != null){
                    selects.add(maxKey);
                    allAreas.removeAll(broadcasts.get(maxKey));
                }
        }
        System.out.println(selects);
    }
}
