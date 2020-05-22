package 剑指Offer;

public class O11_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof {
    public int minArray(int[] numbers) {
        //思入: 二分
        if (numbers.length == 1) return numbers[0];

        int left = 0, right = numbers.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (numbers[left] < numbers[right]) {
                //递增型
                return numbers[left];
            } else if (numbers[left] > numbers[right]) {
                //左高右低
                if (numbers[left] <= numbers[mid]) left = mid + 1;
                else right = mid;
            } else {
                //无法排除
                right--;  //简单排除一个right?
            }
        }
        return numbers[left];
    }

    public int minArray2(int[] numbers) {
        //思入: 改进 mid 和right比较
        if (numbers.length == 1) return numbers[0];

        int left = 0, right = numbers.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) right = mid;  //mid一定在右边,且是右边的较小部分
            else if (numbers[mid] > numbers[right]) left = mid + 1; //mid在左边
            else right--; //相等时,无法区别
        }
        return numbers[left];
    }
}
