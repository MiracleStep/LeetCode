package 贪心法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class _56_合并区间 {
    public static void main(String[] args) {
        int[] intArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };

        Integer[] integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        intArr  = Arrays.stream(integerArr).mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value.intValue();
            }
        }).toArray();
        for (int i : intArr) {
            System.out.println(i);
        }
    }
    public int[][] merge(int[][] intervals) {
        //直接调用API排序即可，注意Comparator传入的需要是引入数据类型(不是基本数据类型)
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new LinkedList<>();
        int[] left = null;
        for(int[] cur : intervals){
            if(left == null){
                left = cur;
                list.add(left);
            } else {
                if(left[1] >= cur[0]){
                    //有重叠区间
                    left[1] = Math.max(left[1], cur[1]);//更新left(left已经保存到list中了)
                } else {
                    //没有重叠区间，添加到list中
                    left = cur;
                    list.add(left);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
