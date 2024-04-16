package 字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _539_最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int maxTime = 24 * 60;
        int res = maxTime;

        int preTime = getMinutes(timePoints.get(0));
        int time0Time = preTime;
        for (int i = 1; i < timePoints.size(); i++) {
            int curTime = getMinutes(timePoints.get(i));
            res = Math.min(res, curTime - preTime);// 相邻时间的时间差
            preTime = curTime;
        }
        res = Math.min(res, time0Time + maxTime - preTime);// 首尾时间的时间差
        return res;
    }

    public int getMinutes(String t) {
        String[] split = t.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
