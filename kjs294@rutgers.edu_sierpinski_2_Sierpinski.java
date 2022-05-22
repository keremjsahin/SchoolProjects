/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Kerem Sahin 
 *
 *************************************************************************/

public class Sierpinski {

    public static double height(double length) {

        double h = length * Math.sqrt(3.0)/2;

        return h;

    }

   
    public static void filledTriangle(double x, double y, double length) {

        double x2 = x - length / 4;
        double y2 = y + height(length)/2;

        double x3 = x + length / 4;
        double y3 = y + height(length)/2;

        double[] xDelta = {x, x2, x3};
        double[] yDelta = {y, y2, y3};

        StdDraw.filledPolygon(xDelta, yDelta);

    }

   
    public static void sierpinski(int n, double x, double y, double length)
    {
        filledTriangle(x, y, length);

        if (n == 1) {
            System.out.println("That's it");
        } else {
            filledTriangle(x, y, length);
            n--;

            sierpinski(n, x-x/2, y, length/2);
            sierpinski(n, x+x/2, y, length/2);
            sierpinski(n, x, y + height(length)/2, length/2);             
        }

    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int length = 1;
        double g = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, height(length));
        StdDraw.line(0.5, height(length), 0.0, 0.0);

        double x = 0.5;
        double y = 0;

        sierpinski(n, x, y, length);

    }
}