package 栈和队列;

import java.util.Stack;

public class _232_用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _232_用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
    //判断输出栈是否为空，如果为空就将输入栈存放的元素放入输出栈
    private void checkOutStack(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
