package java8features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

    public static void main(String[] args) {
        //creating smaple collection
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        //traversing using iterator
        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        //traversing through forEach method of iterable with anonymous class
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer+" ");
            }
        });

        //traversing with consumer interface implementation
        MyConsumer action = new MyConsumer();
        list.forEach(action);

        /**
         * One of the major benefits of the functional interface is the
         * possibility to use lambda expressions to instantiate them.
         * We can instantiate an interface with an anonymous class but the code looks bulky.
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println();
                System.out.println("runnable implementation using anonymous class");
            }
        };

        runnable.run();

        /**
         * Since functional interfaces have only one method, lambda expressions can easily
         * provide the method implementation. We just need to provide method arguments and
         * business logic. For example, we can write above implementation using lambda expression as:
         */
        //int val = 5;
        Runnable r = ()->{
            System.out.println("runnable implementation without anonymous class");
        };

        r.run();

    }

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

    public void accept(Integer t) {
        System.out.print("Consumer impl Value::"+t+" ");
    }
}
