package duke.learn.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Test {

    public Test() {
    }

    static void dowork() {
	System.out.println("line 3");
	System.out.println("line 4");
	throw new OutOfMemoryError("Custom error");
    }

    static void maptest() {
	Map<String, List<String>> people = new HashMap<>();
	people.put("John", Arrays.asList("555-1123", "555-3389"));
	people.put("Mary", Arrays.asList("555-2243", "555-5264"));
	people.put("Steve", Arrays.asList("555-6654", "555-3242"));

	List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
	System.out.println(phones);
    }

    public static void main(String[] args) throws Exception {
	// System.out.println("line 1");
	// System.out.println("line 2");
	// try {
	// dowork();
	// } catch (Error e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println("line 5");
	// maptest();
	Callable<String> callable = new Callable<String>() {
	    @Override
	    public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "=> Inside call");
		return "called from callable";
	    }
	};
	ExecutorService executor = Executors.newFixedThreadPool(12);
	ExecutorService executor2 = Executors.newFixedThreadPool(12);
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));

	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread1"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread2"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread3"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread4"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread5"));
	executor2.execute(() -> System.out.println(Thread.currentThread().getName() + " => in thread6"));

	executor.shutdown();
    }

}
