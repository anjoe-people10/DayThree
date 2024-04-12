class OuterClass{
    int var;

    void display() {
        System.out.println("In outer class");
    }

    class InnerClass {
        void inner() {
            System.out.println("In inner class");
        }
    }
}

abstract class AnonymousAbstractClass {
    abstract void display();
}

public class InnerClassExample {
    public static void main(String[] args) {
        OuterClass o1 = new OuterClass();
        OuterClass.InnerClass i1 = o1.new InnerClass();
        o1.display();
        i1.inner();

        //Anonymous Inner class
        OuterClass o2 = new OuterClass() {
            @Override
          public void display() {
              System.out.println("In anonymous inner class");
          }
        };
        o2.display();

        //Anonymous Abstract Inner class
        AnonymousAbstractClass obj = new AnonymousAbstractClass() {
            @Override
            void display() {
                System.out.println("In anonymous abstract inner class");
            }
        };
        obj.display();
    }
}
