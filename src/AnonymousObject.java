class A {

    A() {
        System.out.println("Object created.");
    }

    public void show() {
        System.out.println("in A show");
    }
}

public class AnonymousObject {

    public static void main(String[] args) {
        new A().show();
        Float a = 5.0F;
    }
}
