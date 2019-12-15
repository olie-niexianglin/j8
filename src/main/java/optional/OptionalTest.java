package optional;

import learn1.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class OptionalTest {

    @Test
    public void test1() throws InterruptedException {
        final List<Employee> employees = Arrays.asList(
                new Employee(1, "2"),
                new Employee(2, "2"),
                new Employee(3, "2"),
                new Employee(4, "2"),
                new Employee(5, "2"));

        Thread thread = new Thread(() -> {
            employees.stream()
                    .forEach(e -> {

                        if (e.getAge() == 2) {

                            System.out.println(Thread.currentThread().getName());
                            throw new RuntimeException("dd");
                        } else {
//                            System.out.println(Thread.currentThread().getName());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            System.out.println(e.getAge());
                        }


                    });
        },"sdsdfs");

        thread.start();


        new CountDownLatch(1).await();


    }
}
