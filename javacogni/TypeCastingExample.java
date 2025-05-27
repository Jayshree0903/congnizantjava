public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;

        int intVal = 25;
        double castedDouble = intVal;

        System.out.println("Original double: " + myDouble);
        System.out.println("After casting to int: " + myInt);
        System.out.println("Original int: " + intVal);
        System.out.println("After casting to double: " + castedDouble);
    }
}
