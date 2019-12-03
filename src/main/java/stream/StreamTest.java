package stream;


import learn1.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * 流（Stream）到底是什么
 * 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列
 * 集合是数据存储，流失数据计算
 * <p>
 * Stream 自己不会存储元素
 * Stream 不会改变源对象
 * Stream 操作是延迟执行的
 * <p>
 * 创建 Stream ->中间操作 ->终止 Stream
 */
public class StreamTest {


    /**
     * 三步操作
     * 1 创建一个 Stream
     * 2 中间操作
     * 3 终止操作
     */
    @Test

    /**
     * 创建 Stream
     */
    public void streamTry() {

        //1 通过 Collection 创建 stream() paralleStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2 通过 Arrays 静态方法 stream 获取数组流
        Employee[] employees = new Employee[10];
        final Stream<Employee> stream1 = Arrays.stream(employees);

        //3 通过 Stream 静态方法 of 创建流
        Stream<Employee> employeeStream = Stream.of(new Employee(), new Employee());

        //4 创建无限流，迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);

        //5 创建无限流，生成
        final Stream<Double> generate = Stream.generate(() -> Math.random());
    }
    
}
