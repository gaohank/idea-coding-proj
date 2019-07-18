package cn.gaohank.idea.java.base_05_collection.map;

import java.util.*;

/*
 * Map：无序，不重复（key值不能重复），没有Stream流操作
 * 1.put    返回value值
 * 2.get
 * 3.containsKey
 * 4.containsValue
 * 5.遍历    得到key或者entry
 * 6.remove 删除对应的元素，返回value值
 * 7.clear
 */
public class Map01HashMap {
    public static void main(String[] args) {
        Map<String, String> nullMap = new HashMap<>();
        nullMap.put("name", null);
        System.out.println(nullMap.get("name"));


        Map<String, String[]> map = new HashMap<String, String[]>();

        // 1.put
        // 2.get
        System.out.println("====1.put/2.get====");
        map.put("红队", new String[]{"赵一，钱二，孙三"});
        map.put("黄队", new String[]{"李四，周五，吴六"});
        map.put("蓝队", new String[]{"郑七，王八，刘十"});
        map.put("绿队", new String[]{"郑七，王八，刘十"}); // value重复
        map.put("黄队", new String[]{"老赵，老李，老王"}); // key重复

        // 通过key来遍历
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + Arrays.toString(map.get(key)));
        }

        System.out.println(keys.stream().noneMatch(s -> s.equals("hank")));

        // entrySet -> iterator遍历
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();

        System.out.println(iterator.next());

        // clear
        map.clear();
        System.out.println(map.size());
    }
}
