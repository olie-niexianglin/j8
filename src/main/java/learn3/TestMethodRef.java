package learn3;

import learn1.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.XMLFormatter;

/**
 * 方法引用：若 lambda 体中的内容已经有方法实现了，我们可以使用 方法引用
 * 可以理解为方法引用是 Lambda 表达式的另外一种表现形式
 * 主要有三种语法形式
 * <p>
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 */
public class TestMethodRef {

    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.out.println(x);

        Consumer<String> consumer1 = System.out::println;
    }

    @Test
    public void test2() {
        Employee employee = new Employee(12, "21");
        Supplier<String> supplier = employee::getName;

        final String s = supplier.get();

        System.out.println(s);
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = Integer::compare;
    }
}
