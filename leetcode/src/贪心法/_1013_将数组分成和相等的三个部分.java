package 贪心法;

public class _1013_将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        //计算加和
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum % 3 != 0){
            return false;//如果加和都不能满足直接返回false
        }
        //加和可以分成三份不代表能把数组分成三份。
        int left = 0;
        for(int i = 0; i < arr.length - 2; i++){
            left += arr[i];
            if(left == sum / 3){
                int mid = 0;
                for(int j = i+1; j < arr.length - 1; j++){
                    mid += arr[j];
                    if(mid == sum / 3){
                        int right = 0;
                        for(int k = j+1; k < arr.length;k++){
                            right += arr[k];
                            if(right == sum/3){
                                //left mid right 都满足即相等
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
