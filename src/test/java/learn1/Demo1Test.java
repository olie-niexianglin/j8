package learn1;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo1Test {

    @Test
    public void test1() {
        final List<Employee> employees = Arrays.asList(new Employee(12, "2342"),
                new Employee(14, "哈哈"),
                new Employee(232, "发生的官方"));

        Collections.sort(employees, (Employee o1, Employee o2) -> {
            if ((o1.getAge().compareTo(o2.getAge()) == 0)) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return (o1.getAge().compareTo(o2.getAge()));
            }
        });

        employees.forEach(System.out::println);
    }

    public void op(Long t1, Long t2, MyFunction<Integer, Long> function) {
        Integer value = function.getValue(t1, t2);
    }

    @Test
    public void test2() {

        op(12L, 34L, (t1, t2) -> Math.toIntExact(t1 + t2));
    }
}