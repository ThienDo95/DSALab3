package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2
 * Status: Complete and thourough tested
 * Last update: 02/08/2017
 * Submitted: 02/09/2017
 * Comment: test suite and sample attatched
 * @author: Thien Do
 * @version:  2017.02.09
 */
public class Driver
{
static BufferedReader stdin = new BufferedReader ( new  InputStreamReader (System.in));
	
	public static void main(String[] args) throws IOException
	{
		MyListReferenceBased mb = new MyListReferenceBased();
		int i;
		
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert item to list");
			System.out.println("2. Remove item from list");
			System.out.println("3. Get item from list");
			System.out.println("4. Clear list");
			System.out.println("5. Print size and content of list");
			System.out.println("6. Delete the largest item in the list");
			System.out.println("7. Reverse list");
			System.out.println("8. Exit Program");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);
			
			if (i > 0 && i < 8)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter item: ");
						String item = stdin.readLine().trim();
						System.out.println(item);
						System.out.println("Enter position to insert item in: ");
						String position = stdin.readLine().trim();
						System.out.println(position);
						int p = Integer.parseInt(position);
						if (p >= 0 && p <= mb.size())
						{
							mb.add(p, item);
							System.out.println(item + " inserted in position "+
												p + " in the list");
						}
						else
						{
							System.out.println("Index is invalid");
						}
					break;
					case 2:
						System.out.println("Enter position to remove item from: ");
						String rp = stdin.readLine().trim();
						System.out.println(rp);
						int rpn = Integer.parseInt(rp);
						if( rpn >= 0 && rpn <= mb.size() - 1)
						{
							System.out.println(mb.get(rpn) + " has been removed from position "+
															rpn  + " in the list");
							mb.remove(rpn);
							
						}
						else
						{
							System.out.println("Index is invalid");
						}
						break;
					case 3:
						System.out.println("Enter position to retrieve item from: ");
						String rt = stdin.readLine().trim();
						System.out.println(rt);
						int rtn = Integer.parseInt(rt);
						if(rtn >= 0 && rtn <= mb.size())
						{
							System.out.println(mb.get(rtn) + " has been retrieved at position "
														   + rtn);
														
						}
						else
						{
							System.out.println("Index is invalid");
						}
						break;
					case 4:
							mb.removeAll();
							System.out.println("CLEARED");
						break;
					case 5:
						if (mb.isEmpty() == true)
						{
							System.out.println("List is empty");
						}
						else
						{
							System.out.println("List of size " + mb.size() 
												+ " has the follow items " 
												+ mb.toString());
						}
						break;
					case 6:
						if (mb.size()==0)
						{
							System.out.println("List is empty. Cannot delete largest string.");
						}
						else
						{
							Object curr = mb.get(0);
							int currItem = 0;
							int lastItem = mb.size()-1;
							int incr = 1;
							while(incr <lastItem)
							{
								int comp = ((String)curr).compareTo((String)mb.get(incr+1));
								if(comp < 0)
								{
									curr = mb.get(incr+1);
									currItem = incr+1;
								}
								incr++;	
							}
							mb.remove(currItem);
							System.out.println(curr + " was the largest String and has been removed.");
						}
						break;
					case 7:
						if (mb.size() == 0)
						{
							System.out.println("List is empty. Cannot reverse.");
						}
						else
						{
							int firstIndex = 0;
							Object curr = null;
							do
							{
								curr = mb.get(mb.size()-1);
								mb.remove(mb.size()-1);
							
								mb.add(firstIndex, curr);
								
								firstIndex ++;
							}while(firstIndex < mb.size()-1);
						}
						break;
				}
			}
			else if ( i == 8)
			{
				System.out.println("You are now exited the application");
				break;
			}
			else 
			{
				System.out.println("No such option exists for " + i );
			}
		}while(i < 8 || i > 8);
	}
}
