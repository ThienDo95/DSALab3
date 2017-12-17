package v1;
import java.io.*;
/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 3
 * Status: Complete and thouroughly tested
 * Last update: 02/08/2017
 * Submitted: 02/09/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.09
 */
public class DriverCompareTo
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException
	{	
			System.out.println("Enter first string: ");
			String one = stdin.readLine().trim();
			System.out.println(one);
			System.out.println("Enter second string: ");
			String two = stdin.readLine().trim();
			System.out.println(two);
			
			System.out.println("This is your comparasion result:" + one.compareTo(two));
			
	}
			
}


