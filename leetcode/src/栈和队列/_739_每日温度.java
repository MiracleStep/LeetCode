package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _739_每日温度 {
    //反向遍历
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            int cur = temperatures[i];
            while (!stack.isEmpty()){
                if (temperatures[stack.peek()] > cur) { //之后的温度大于当前温度, 说明之后有温度高的不用出栈
                    res[i] = stack.peek() - i;
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);//添加当前索引
        }
        return res;
    }

    //正向遍历
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        // Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
