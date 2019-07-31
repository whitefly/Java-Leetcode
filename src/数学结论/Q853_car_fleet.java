package 数学结论;

public class Q853_car_fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
         思入: 从右边到左遍历, 计算每辆车没有阻碍的情况下到的时间(剩下距离/速度)
         若<=前车小,则和前车属于同个车队, last保留前一个车队的需要时间
         */
        int count = 0;
        double last = 0; //前一个车队所需要的时间
        sort(position, speed, 0, position.length - 1);
        for (int i = position.length - 1; i >= 0; i--) {
            double need = (target - position[i]) / (double) speed[i];
            if (need <= last) continue;
            last = need;
            count++;
        }
        return count;
    }

    private void sort(int[] positions, int[] speeds, int low, int high) {
        if (high <= low) return;
        int pivot = positions[low];
        int store = low;
        for (int i = low + 1; i <= high; i++) {
            if (positions[i] < pivot) swap(positions, speeds, i, ++store);
        }
        swap(positions, speeds, low, store);
        sort(positions, speeds, low, store - 1);
        sort(positions, speeds, store + 1, high);
    }

    private void swap(int[] positions, int[] speeds, int L, int R) {
        int position = positions[L], speed = speeds[L];
        positions[L] = positions[R];
        speeds[L] = speeds[R];
        positions[R] = position;
        speeds[R] = speed;
    }

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3};
//        int[] speed = {2, 4, 1, 1, 3};
        int target = 10;
        int[] position = {0, 4, 2}; // {0,2,4}, {2,3,1}
        int[] speed = {2, 1, 3};
        Q853_car_fleet solver = new Q853_car_fleet();
        System.out.println(solver.carFleet(target, position, speed));

    }

}
