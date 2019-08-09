package 概率;

import java.util.Random;

public class Q478_generate_random_point_in_a_circle {

    /*
    思入: reject sampling思想, 从正方形中取,没有落到圆中就是重新投
     */
    private Random r;
    private double radius;
    private double square;
    private double dia;
    private double x0;
    private double y0;

    public Q478_generate_random_point_in_a_circle(double radius, double x_center, double y_center) {
        r = new Random();
        this.radius = radius;
        this.dia = 2 * radius;
        this.square = Math.pow(radius, 2);
        this.x0 = x_center;
        this.y0 = y_center;
    }

    public double[] randPoint() {
        double x = r.nextDouble() * dia - radius, y = r.nextDouble() * dia - radius;
        return isInSide(x, y) ? new double[]{x + x0, y + y0} : randPoint();
    }

    private boolean isInSide(double x, double y) {
        return (x * x + y * y) <= square;
    }

    public static void main(String[] args) {
        double radius = 1;
        double x = 0;
        double y = 0;
        Q478_generate_random_point_in_a_circle s = new Q478_generate_random_point_in_a_circle(radius, x, y);
    }
}
