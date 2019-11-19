package learn2;


import com.sun.org.apache.bcel.internal.generic.LUSHR;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;
import sun.security.ssl.HandshakeOutStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CoreFunctionInterface {

    //Consumer<T>
    @Test
    public void test1() {
        happy(123d, (m) -> System.out.println(m));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    @Test
    public void test2() {
        getNumList(100, () -> (int) Math.random());

    }

    //Supplier<T> 供给型接口
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }

        return list;
    }


    @Test
    public void test3() {
        String param = "hello world";
        param = strs(param, (str) -> str + str);

        System.out.printf(param);
    }

    //Function
    public String strs(String str, Function<String, String> function) {

        return function.apply(str);
    }


    //Predicate
    public List<String> filter(List<String> strs, Predicate<String> predicate) {

        List<String> result = new ArrayList();
        strs.forEach((x) -> {
            if (predicate.test(x)) {
                result.add(x);
            }
        });

        return result;
    }

    @Test
    public void test4() {

        List<String> list = Arrays.asList("hello", "wp", "s");

        filter(list, (x) -> x.length() > 2).forEach((x) -> System.out.printf(x));
    }
}


