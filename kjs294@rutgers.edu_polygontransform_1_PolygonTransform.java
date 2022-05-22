/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: Kerem Sahin
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {

	double array2[] = new double[array.length]; 
  
        array2 = array;  
  
        array2[0]++; 
  
        return array2;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

	for(int i = 0; i < x.length; i++){
        x[i] = alpha * x[i];
    }
    for(int i = 0; i < y.length; i++){
        y[i] = alpha * y[i];
    }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {

	for(int i = 0; i < x.length; i++){
        x[i] = x[i] + dx;
    }
    for(int i = 0; i < y.length; i++){
        y[i] = y[i] + dy;
    }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

	for(int i = 0; i < x.length; i++){
        x[i] = (x[i] * Math.cos(theta)) - (y[i] * Math.sin(theta));
    }
    for(int i = 0; i < y.length; i++){
        x[i] = (x[i] * Math.cos(theta)) + (y[i] * Math.sin(theta));
    }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
       double x[] = { 0, 1, 1, 0 };
       double y[] = { 0, 0, 2, 1 };
    }
}
