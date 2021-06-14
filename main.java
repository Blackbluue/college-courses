public class Discussion8 {
	public static void main (String[] args) {
        new Child();
	}		
}

class Parent {
    Parent() {
        method();
    }

    void method() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child() {
        super();
    }

    @Override
    void method() {
        System.out.println("Child");
    }
}