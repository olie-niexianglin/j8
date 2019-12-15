package defaultMethod;

public interface DefaultMethodInterface {

    static void sayHelloStatic() {
        System.out.println("Hello Interface Static");
    }

    default void sayHello() {
        System.out.printf("Hello Interface");
    }
}

