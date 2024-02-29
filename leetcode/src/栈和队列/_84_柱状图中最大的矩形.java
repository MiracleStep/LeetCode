package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

public class _84_柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new LinkedList<>();//维护一个单调递增的栈(单调栈)
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                //遍历到的高度比单调递增栈的栈顶节点矮
                int curHeight = heights[stack.poll()];//处理这个高节点，以当前高度为基础找到最大面积。
                while (!stack.isEmpty() && curHeight == heights[stack.peek()]) {
                    stack.pop();//pop掉所有相同高度的
                }

                int curWidth;//开始计算宽度
                if (!stack.isEmpty()) {
                    curWidth = i - stack.peek() - 1;
                } else {
                    curWidth = i;
                }

                res = Math.max(curWidth * curHeight, res);//比较，找到最大值
            }
            stack.push(i);
        }

        //已经处理的都是高的，剩下的都是矮的
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            while (!stack.isEmpty() && curHeight == heights[stack.peek()]) {
                stack.pop();//pop掉所有相同高度的
            }

            int curWidth;//开始计算宽度
            if (!stack.isEmpty()) {
                curWidth = len - stack.peek() - 1;
            } else {
                curWidth = len;
            }

            res = Math.max(curWidth * curHeight, res);//比较，找到最大值
        }
        return res;
    }
}
