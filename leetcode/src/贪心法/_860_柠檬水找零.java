package 贪心法;

public class _860_柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        //局部最优：每次找零都尽可能找最大的，因为最小的找零更加通用。以达到全局最优。所有找零都能满足。不能满足就return false;
        //分别对应5元，10元，20元。
        int[] money = new int[3];
        for (int i = 0; i < bills.length; i++) {
            int pay = bills[i];
            if (pay != 5) {
                if (pay == 10) {
                    //pay == 10
                    if (money[0] == 0) return false; //只有一种找零：找5元
                    money[1]++;//增加10元
                    money[0]--;//找5元
                } else {
                    //pay == 20
                    //优先找10元的
                    if (money[1] >= 1 && money[0] >= 1) {
                        money[1]--;//找一张10元
                        money[0]--;//找一张5元;
                        money[2]++;
                    } else if (money[0] >= 3) {
                        money[2]++;
                        money[0] -= 3;//找3张5元
                    } else {
                        return false;
                    }
                }
            } else {
                money[0]++;
            }
        }
        return true;
    }
}
