package learn1;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {


        test1();
    }



    public static void test1() {
        final List<Employee> employees = Arrays.asList(new Employee(12, "2342"),
                new Employee(14, "哈哈"),
                new Employee(232, "发生的官方"));

        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                if ((o1.getAge().compareTo(o2.getAge()) == 0)) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return (o1.getAge().compareTo(o2.getAge()));
                }
            }
        });

        employees.forEach(System.out::println);

    }
}
