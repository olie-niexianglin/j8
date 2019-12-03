package practice;

import learn1.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Practice {

    List<Employee> employees = Arrays.asList(new Employee(10, "10岁"),
            new Employee(20, "20岁"),
            new Employee(30, "30岁"),
            new Employee(40, "40岁"));

    @Test
    public void test() {
        /**
         * 给定一个数字列表，返回一个由每个数平方构成的列表
         */
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};

        Arrays.stream(integers)
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    @Test
    public void test1() {
        /**
         * 统计 employees 列表的数量
         */
        final Integer reduce = employees.stream()
                .map(x -> 1)
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

    }
}
