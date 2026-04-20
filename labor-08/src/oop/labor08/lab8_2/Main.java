package oop.labor08.lab8_2;

public class Main {
    public static void main(String[] args) {
//        System.out.println("--- StackAggregation (Integer) ---");
//        StackAggregation stack1 = new StackAggregation(5);
//
//        for (int i = 0; i < 10; i++) {
//            stack1.push(i);
//        }
//
//        System.out.print("Stack tartalma (LIFO): ");
//        while (!stack1.isEmpty()) {
//            System.out.print(stack1.top() + " ");
//            stack1.pop();
//        }
//        System.out.println();
//
//        System.out.println("\n--- StackInheritance (Character) ---");
//        StackInheritance stack2 = new StackInheritance(5);
//
//        char[] betuk = {'A', 'B', 'C', 'D', 'E'};
//        for (char c : betuk) {
//            stack2.push(c);
//        }
//
//        System.out.print("Stack tartalma (LIFO): ");
//        while (!stack2.isEmpty()) {
//            System.out.print(stack2.top() + " ");
//            stack2.pop();
//        }
//        System.out.println();
//
//        System.out.println("\n--- Határérték teszt (Integer) ---");
//        StackAggregation stack3 = new StackAggregation(2);
//        stack3.push(10);
//        stack3.push(20);
//
//        if (stack3.isFull()) {
//            System.out.println("A stack megtelt (kapacitás: 2).");
//        }
//
//        stack3.pop();
//        stack3.pop();
//
//        if (stack3.isEmpty()) {
//            System.out.println("A stack kiürült. Top értéke: " + stack3.top());
//        }

        StackAggregation stack1 = new StackAggregation( 5 );
        for( int i=0; i<10; ++i ){
            stack1.push( i );
        }
        System.out.print("StackAggregation : ");
        while( !stack1.isEmpty() ){
            System.out.print( stack1.top() + " ");
            stack1.pop();
        }
        System.out.println();
        StackInheritance stack2 = new StackInheritance( 5 );
        for( int i=0; i<10; ++i ){
            stack2.push( i );
        }
        stack2.remove( 1 );
        System.out.print("StackInheritance : ");

        while( !stack2.isEmpty() ){
            System.out.print( stack2.top() + " ");
            stack2.pop();
        }
        System.out.println();
    }
}
