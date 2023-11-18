package java8features;

@FunctionalInterface
interface A {
    void show();
}

@FunctionalInterface
interface C {
    int sum(int a, int b);
}

class B implements A, C {

    @Override
    public void show() {
        System.out.println("Hello world: B");
    }

    @Override
    public int sum(int a, int b) {
        throw new UnsupportedOperationException("Unimplemented method 'sum'");
    }
}

public class LambdaExpr {
    public static void main(String[] args) {
        // object creation using anonymous inner class
        A a = new A() {
            @Override
            public void show() {
                System.out.println("Hello world");
            }
        };
        a.show();

        // object creation using lambda expression
        A a1 = () -> System.out.println("Hello world: LamdaExpr");
        a1.show();

        C c = (i, j) -> i + j;
        int result = c.sum(1, 2);
        System.out.println(result);
    }
}
