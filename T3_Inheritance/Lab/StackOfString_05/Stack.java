package T3_Inheritance.Lab.StackOfString_05;

import java.util.ArrayDeque;

public class Stack {
    private ArrayDeque<String> data = new ArrayDeque<>();

    public void push(String item){
        data.push(item);
    }

    public String pop(){
        return data.pop();
    }

    public String peek(){
     return data.peek();
    }
}
