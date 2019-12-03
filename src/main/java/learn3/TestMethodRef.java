package learn3;

import learn1.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若 lambda 体中的内容已经有方法实现了，我们可以使用 方法引用
 * 可以理解为方法引用是 Lambda 表达式的另外一种表现形式
 * 主要有三种语法形式
 * <p>
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名(调用者和入参都是同一个类型)
 * <p>
 * 构造方法引用
 * 类::构造方法
 */
public class TestMethodRef {


    /**
     * 实例方法引用
     * 对象：实例方法
     */
    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.out.println(x);

        Consumer<String> consumer1 = System.out::println;
    }


    /**
     * 实例方法引用
     * 对象：方法
     */
    @Test
    public void test2() {
        Employee employee = new Employee(12, "21");
        Supplier<String> supplier = employee::getName;

        final String s = supplier.get();

        System.out.println(s);
    }


    /**
     * 静态方法引用
     * 类：方法
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = Integer::compare;
    }


    /**
     * 实例方法引用（调用者和参数均为目标类）
     * 类：方法
     */
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;
    }

    @Test
    public void test5() {
        Supplier<Employee> supplier = () -> new Employee();

        Supplier<Employee> supplier1 = Employee::new;
    }
}
