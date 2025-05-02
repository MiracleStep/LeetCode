package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _LCR_125_图书整理II {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public _LCR_125_图书整理II() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}
