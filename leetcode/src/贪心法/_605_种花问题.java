package 贪心法;

public class _605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int len = flowerbed.length;
        for(int i = 0; i < flowerbed.length && n > 0; ){
            if(flowerbed[i] == 1){
                //当前位置有花，后面肯定没花，但i += 2不一定有花。
                i += 2;
            } else if(i == len - 1 || flowerbed[i + 1] == 0){
                //当前位置和前面没花
                n--;
                i += 2;
            } else {
                i += 3;//后面有花
            }
        }

        return n <= 0;
    }

    //另一种写法
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                return n <= 1;
            } else {
                return n == 0;
            }
        }
        int res = 0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            res++;
        }
        for(int i = 1; i < flowerbed.length  - 1; i++){
            if(flowerbed[i] == 0){
                //没有种花
                if(flowerbed[i-1] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;//种上花
                    res++;
                    if(res == n){
                        return true;
                    }
                }
            }
        }
        if(flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0){
            res++;
        }
        return n <= res;
    }
}
