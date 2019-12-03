package learn4;

import learn1.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {

    List<Employee> list = Arrays.asList(
            new Employee(1, "342")
            , new Employee(1, "32")
            , new Employee(3, "ewe")
            , new Employee(4, "dsfs"));

    /**
     * 筛选与切片:中间操作
     * filter:从流中排除元素
     * limit:截断流，使其元素不超过制定元素
     * skip:跳过 n 各元素
     * distinct:筛选，通过流所生成的元素的 hashcode 和 equals 去除重复元素
     */

    @Test
    public void testFilter() {

        list.stream().filter(e -> {
            System.out.println("Hello World");
            return e.getAge() > 2;
        }).forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        list.stream().filter(e -> e.getAge() > 2)
                .limit(1).forEach(System.out::println);
    }

    @Test
    public void testSkip() {

        list.stream().filter(e -> e.getAge() > 1).skip(100).forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射：中间操作
     * map:接收一个 Function 作为参数，该函数会作用于每一个元素上，并将其映射成为一个新的元素
     * flatMap:接收一个 Function 作为参数，将流中的每一个值转换为留一个流，并将多有流连接成一个流
     */
    @Test
    public void testMap() {
        list.stream()
                .map(e -> e.getAge())
                .forEach(System.out::println);

    }

    @Test
    public void testFlatMap() {
        list.stream().
                flatMap(e -> Stream.of(e))
                .forEach(System.out::println);
    }

    /**
     * 排序：中间操作
     * 自然排序：若流中的元素实现了 Comparable 接口，按照类本身定义的排序规格排序
     * 制定排序：按照 Comparator 实现类的排序规则排序
     */
    @Test
    public void testNature() {
        list.stream()
                .sorted().forEach(System.out::println);
    }

    @Test
    public void testManual() {
        list.stream()
                .sorted((e1, e2) -> e1.getAge().compareTo(e2.getAge()))
                .forEach(System.out::println);
    }

    /**
     * 匹配与查找：终止操作
     * allMatch
     * anyMatch
     * noneMatch
     * findFirst
     * findAny
     * count
     * max
     * min
     */
    @Test
    public void testAllMatch() {
        //全部匹配
        final boolean b = list.stream().allMatch(
                e -> e.getAge() > 10);
        System.out.println(b);
    }

    @Test
    public void testAnyMatch() {
        //任意一个匹配
        final boolean b = list.stream()
                .anyMatch(e -> e.getAge() > 2);
        System.out.println(b);
    }

    @Test
    public void testNoneMatch() {
        //没有一个匹配
        final boolean b = list.stream().noneMatch(e -> e.getAge() < -1);
        System.out.println(b);
    }

    @Test
    public void testFindFirst() {
        final Optional<Employee> first = list.stream().sorted((e1, e2) -> e1.getAge().compareTo(e2.getAge()))
                .findFirst();
        final Employee employee = first.get();
        System.out.println(employee);
    }

    @Test
    public void testFindAny() {
        final Optional<Employee> first = list.stream().sorted((e1, e2) -> e1.getAge().compareTo(e2.getAge()))
                .findAny();
        final Employee employee = first.get();
        System.out.println(employee);
    }

    @Test
    public void testCount() {
        final long count = list.stream().count();
        System.out.printf("sd", count);
    }

    @Test
    public void testMax() {
        final Optional<Employee> max = list.stream().max((e1, e2) -> e1.getAge().compareTo(e2.getAge()
        ));
        final Employee employee = max.get();
        System.out.println(employee);

    }

    @Test
    public void testMin() {
        final Optional<String> min = list.stream().map(e -> e.getName())
                .min(String::compareTo);
        System.out.println(min.get());
    }

    /**
     * reduce:终止操作
     * 将流中的元素按照指定的操作反复结合起来，得到一个新值
     */
    @Test
    public void testReduce() {
        final Integer reduce = list.stream()
                .map(e -> e.getAge())
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        final Optional<Integer> reduce1 = list.stream()
                .map(e -> e.getAge())
                .reduce((x, y) -> x + y);

        System.out.println(reduce1.get());

    }

    /**
     * collect:收集，终止操作
     * collect 将流转换为其他形式，接收一个 Collector 接口的实现
     */
    @Test
    public void testCollect() {
        //数据转换 -> list
        final List<Employee> collect = list.stream()
                .collect(Collectors.toList());

        //数据转换 -> set
        final Set<Integer> collect1 = list.stream()
                .map(Employee::getAge)
                .collect(Collectors.toSet());

        //数据转换 -> 自定义转换类型
        final HashSet<Integer> collect2 = list.stream()
                .map(Employee::getAge)
                .collect(Collectors.toCollection(HashSet::new));

        //count
        final Long collect3 = list.stream()
                .collect(Collectors.counting());
        System.out.println(collect3);

        //平均值
        final Double collect4 = list.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collect4);

        //sum
        final Integer collect5 = list.stream()
                .collect(Collectors.summingInt(Employee::getAge));
        System.out.println(collect5);

        //max
        final Optional<Employee> collect6 = list.stream()
                .collect(Collectors.maxBy(
                        (e1, e2) -> {
                            return e1.getAge().compareTo(e2.getAge());
                        }
                ));
        System.out.println(collect6.get());

        //min
        final Optional<Integer> collect7 = list.stream()
                .map(Employee::getAge).
                        collect(Collectors.minBy(Integer::compareTo));
        System.out.println(collect7);
    }

    //分组
    @Test
    public void testGroup() {
        final Map<Integer, List<Employee>> collect = list.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));
        System.out.println(collect);

        final Map<Integer, Map<String, List<Employee>>> collect1 = list.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(e -> {
                    if (e.getAge() > 1) {
                        return "小孩子";
                    } else {
                        return "大孩子";
                    }
                })));
        System.out.println(collect1);

    }

    //分区：终止操作
    @Test
    public void testPartition() {
        final Map<Boolean, List<Employee>> collect = list.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 1));
        System.out.println(collect);
    }

    //统计：终止操作
    @Test
    public void testStatistic() {
        final IntSummaryStatistics collect = list.stream()
                .collect(Collectors.summarizingInt(e -> e.getAge()));


        System.out.println(collect);

        final String collect1 = list.stream()
                .map(e -> e.getName())
                .collect(Collectors.joining(",", "start ", " end"));
        System.out.println(collect1);
    }

}

