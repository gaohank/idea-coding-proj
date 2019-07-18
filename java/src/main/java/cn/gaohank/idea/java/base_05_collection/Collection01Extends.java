package cn.gaohank.idea.java.base_05_collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 *     Iterator<----继承----Collection<----继承----List<----实现-----ArrayList
                                                |             |
                                                |               -----LinkedList
                                                |
                                                ---Set<-----实现---HashSet<----继承----LinkedHashSet
                                                        |
                                                        ----继承---SortedSet<--实现----TreeSet

         Map<------HashMap<----LinkedHashMap
                |
               ----SortedMap<----TreeMap
 */
public class Collection01Extends {
    /*
     * Collection常用方法：
     * add();     增加元素，元素可重复
     * remove();    删除元素
     * addAll();    增加另一个集合中所有元素
     * contains();  是否包含元素
     * clear();  清除队列
     * iterator();  遍历
     * size();    集合大小
     * isEmpty(); 是否为空
     */
    @SafeVarargs
    public static <T> Collection<T> getCollection(T ... values) {
        return new ArrayList<>(Arrays.asList(values));
    }

    // 遍历
    public static <T> void display(Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static <T> void displayForeach(Collection<T> collection) {
        collection.forEach(System.out::println);
    }

    /*
     * 集合产生stream流对象，可以进行：
     * 1.count    计数
     * 2.collect
     * 3.map     得到符合条件的新流
     * 4.max     取最大元素
     * 5.sort    排序
     * 6.filter    过滤
     * 7.distinct    去重
     */

    public static <T> int getCount(Collection<T> collection) {
        return collection.size();
    }

    // 转化为delimiter分隔的字符串
    public static <T> String getString(Collection<T> collection, String delimiter) {
        return collection.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    public static int getMax(Collection<Integer> collection) {
        return collection.stream().max(Integer::compareTo).orElse(0);
    }

    public static int getMin(Collection<Integer> collection) {
        return collection.stream().max(Comparator.reverseOrder()).orElse(0);
    }

    public static List<Integer> getSort(Collection<Integer> collection) {
        return collection.stream().sorted((o1, o2) -> o2 - o1).distinct().collect(Collectors.toList());
    }

    public static List<Integer> getFilter(Collection<Integer> collection) {
        return collection.stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
    }
}
