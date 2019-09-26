package duke.learn.util;

import duke.learn.util.Outer.Inner;

public class Outer {

    void outerMethod() {
	System.out.println("Inside Outer method");
	new Inner().innerMethod();
    }

    public class Inner {

	void innerMethod() {
	    System.out.println("Inside inner");
	    outerMethod();
	}
    }

}

class Tester {
    public static void main(String[] args) {
	Outer outer = new Outer();
	Inner inner = outer.new Inner();
    }
}