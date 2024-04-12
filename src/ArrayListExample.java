import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//ArrayList is a dynamic array (resizes)
public class ArrayListExample {
    public static void main(String[] args) {
        // List instead of Collection as it implements get method
        List<Integer> numbers = new ArrayList<Integer>();

        //add()
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        //get()
        System.out.println(numbers.get(0));

        //set()
        int prev = numbers.set(0, 7);

        //indexOf()
        System.out.printf("Element %d replaced by %d at index %d\n", prev, numbers.get(0), numbers.indexOf(7));
        System.out.println(numbers);

        //remove(index)
        numbers.remove(1);
        System.out.println(numbers);

        //add(index, Object) [add() VS set()]
        numbers.add(1, 5);
        System.out.println(numbers);

        //remove(Object)
        numbers.remove(new Integer(5));
        System.out.println(numbers);

        //size() and contains()
        for(int i = 0; i < numbers.size(); i++) {
            int temp = numbers.get(i);
            if(numbers.contains(temp)) {
                System.out.println(temp);
            }
        }

        //toArray()
        System.out.print("Using toArray() method: ");
        for(Object number : numbers.toArray()) {
            Integer element = (Integer) number;
            System.out.print(element + " ");
        }

        //Iterator
        System.out.print("\nUsing Iterator object: ");
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        numbers.sort(Integer::compareTo);

        //Enhanced for loop
        System.out.print("\nUsing enhanced for loop: ");
        for(int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
