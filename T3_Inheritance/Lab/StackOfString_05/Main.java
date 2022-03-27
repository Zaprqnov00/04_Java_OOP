package T3_Inheritance.Lab.StackOfString_05;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
