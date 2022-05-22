package poly;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements evaluate, add and multiply for polynomials.
 * 
 * @author Kerem Sahin
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node add(Node poly1, Node poly2) {
		Polynomial addPolynomial = new Polynomial();
		Node x = this.poly;
		Node x2 = poly2.poly; 
		addPolynomial.poly = new Node(0, 0, null);
		Node result = addPolynomial.poly;
		while((x != null) || (x2 != null))
	{
		if(result.data.coeff > 0 || result.data.coeff < 0)
			{result.next = new Node(0, 0, null);
			result = result.next;
			}
			if((x2 != 0) && ((x == 0) || (x.data.degree > x2.data.degree)))
			{
			result.data.coeff = x2.data.coeff;
			result.data.degree = x2.data.degree;
			x2 = x2.next;
			}
			else if((x2 == 0) || (x.data.degree < x2.data.degree))
			{
			result.data.coeff = x.data.coeff;
			result.data.degree = x.data.degree; 
			x = x.next;
			}
			else if(x.data.degree == x2.data.degree)
			{
			result.data.coeff = x.data.coeff + x2.data.coeff;
			result.data.degree = x.data.degree;
			x = x.next;
			x2 = x2.next;
			}
		}
	   
		if((addPolynomial.poly.next == 0) && (result.data.coeff == 0))
		{
		addPolynomial.poly = null;
		}
	   
		return null;
	}
	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {
	Polynomial multiplyPolynomial = new Polynomial(); 
	Node x = this.poly;      

    while(x != 0)
       {
    	Node x2 = poly1.poly; 
        Polynomial newPoly = new Polynomial(); 
        newPoly.poly = new Node(0, 0, null);
        Node x3 = newPoly.poly;
        while(x2 != 0)
           {
		x3.data.degree = x.data.degree + x2.data.degree;
		x3.data.coeff = x.data.coeff * x2.data.coeff;
        	if((x.next != null) || (x2.next != null)){
		x3.next = new Node(0, 0, null);
        x3 = x3.next;
        x2 = x2.next; 
           }  
    x = x.next;
     multiplyPolynomial = multiplyPolynomial.add(newPoly);
       }
	return null;
	}
		
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {
	Node y = this.poly;
    double result = 0;
    while(y != null)
       {
result = (double) (result + y.data.coeff * (Math.pow(x, y.data.degree)));
y = y.next;
       }
      
	return result;
   }

   // toString method implementation
   public String toString()
   {
       if(poly == null)
           return "0";
       else
       {
           String result;

           result = poly.data.toString(); poly
           Node x = poly.next;
           while(x != null)
           {
               result = x.data.toString() + " + " + result;
               x = x.next;
           }
          
           return result;
		return 0;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node x = poly.next ; x != null ;
		x = x.next) {
			retval = x.term.toString() + " + " + retval;
		}
		return retval;
	}	
}
