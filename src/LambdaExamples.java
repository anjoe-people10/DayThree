@FunctionalInterface
interface DemoInterface {
    String display(String str);
}

public class LambdaExamples {
    public static void main(String[] args) {
        String name = "Anjoe";
        DemoInterface demo = (s) -> {
           return ("In Lambda, My name is: " + s);
        };

        //Syntactic Sugar
        DemoInterface shrink = s -> ("In Lambda, My name is: " + s);

        System.out.println(demo.display(name));
    }
}
