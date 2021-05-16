package project4;
import java.util.*;
/**
 * 
 * @author Devesh
 * Class that explores a way to the end of the array
 * two methods used the  main method and the exploreRecursive method
 * no datafields, constructors, or member variables;
 * The class contains a static variable which is used to 
 * keep track of the number of solutions through the recursive calls and backtracking. 
 */

public class WayFinder 
{
	static int count=0;
	/**
	 * 
	 * @author Devesh
	 *This is the recursive function that finds a way to the end of the array 	
	 *@param args is the original array that is modified during recursive calls to keep track of the index
	 *that  we  have visited by turning it's value to 0. 
	 *@param index is the value incremented or decrement in the recursive function calls depending
	 *on if we are moving left or right
	 *@param paths maintains the elements of the original array and is used to store each step 
	 *that is taken in an arraylist. 
	 *@param element is the arraylist that is used to store each step taken that which are
	 *string array.
	 *This function continously goes right and adds this step to the arraylist. It goes right
	 * until it ends up out of the array bounds or ends up on an value of 0. 
	 * Then it returns to the index it was last on and removes the step from the arraylist.
	 * It then goes left from that previous index and adds this step to the array list. .
	 *If again it ends up out of the bounds of the array or on a value of 0 it returns removes the step  and goes back
	 *again to the previous index it was on and goes left from there. It repeats this until it 
	 *ends up on the last index which is my base case. If this is reached it prints all the steps
	 *part of the arraylist. 
	 *count which is the static variable is incremented everytime the base case is reached indicating
	 *the number if solutions. 
	 */
	
private static void exploreRecursive(String [] args, int index, String [] paths, ArrayList<String[]> element)
{
	if(index<0 || index> args.length-1)
	{
		return ;
	}
	if (index==args.length-1)
	{
		count++;
		for(int i=0;i<element.size();i++) 
		{
			String [] beef= element.get(i);
			System.out.print("[");
			for(int y=0;y<beef.length;y++) 
			{
				if(y==beef.length-1) 
				{
					System.out.printf(" %2s%s", beef[y].substring(0,1), " ");
					continue;
				}
				if(beef[y].length()>2) 
				{
					if(y==0)
						System.out.printf("%2s%s,", beef[y].substring(0,2),beef[y].substring(2));
					else
					System.out.printf(" %2s%s,", beef[y].substring(0,2),beef[y].substring(2));
				}
				else if(beef[y].length()>1 && (beef[y].substring(1,2).equalsIgnoreCase("R")||beef[y].substring(1,2).equalsIgnoreCase("L") ))
				{
					if(y==0) 
						System.out.printf("%2s%s,", beef[y].substring(0,1), beef[y].substring(1,2) );
					else
					System.out.printf(" %2s%s,", beef[y].substring(0,1), beef[y].substring(1,2) );
				}
				else if(beef[y].length()>1)
				{
					if(y==0)
						System.out.printf("%2s%s,", beef[y].substring(0,2), " ");
					else
					System.out.printf(" %2s%s,", beef[y].substring(0,2), " ");
				}
				else 
				{
					if(y==0) 
						System.out.printf("%2s%s,", beef[y].substring(0,1), " ");
					else
					System.out.printf(" %2s%s,", beef[y].substring(0,1), " ");
				}
			}
			System.out.print("]\n");
		
		}
		System.out.print("\n");
		return ;
	} 
	else
	{ 
	int a=Integer.parseInt(args[index]);
	if(a==0) 
		return  ;
	if(index==0 && Integer.parseInt(args[index+a])!=0) 
	{
		String[] path1= new String[paths.length];
		for(int i=0;i<path1.length;i++) 
		{
			path1[i]=paths[i];
		}
		path1[index]=Integer.toString(a) +"R";
		element.add(path1);
		exploreRecursive(args, index + a, paths,element);
	}
    else 
    {
    	args[index]="0";
    	String [] path2= new String[paths.length];
    	for(int i=0;i<path2.length;i++)
    	{
			path2[i]=paths[i];
		}
    	path2[index]=Integer.toString(a) +"R";
    	element.add(path2);
    	exploreRecursive(args, index+a,paths,element);
		element.remove(path2);
		path2[index]=Integer.toString(a)+"L";
		element.add(path2);
		exploreRecursive(args, index-a,paths,element);
		args[index]=Integer.toString(a);
		element.remove(path2);
		path2[index]=Integer.toString(a);	
	}
    }
}	
/**
 * 
 * @author Devesh
 * @param args is the array of integers taken in from the command line that serves as the array puzzle
 *This is the main method of the class that takes in the array puzzle to work with. 
 *First I valid the command line arguments according to all the requirments
 *I print error messages as required if there are  less than 2 arguments,
 *if last argument doesn't =0, if there is negative number, if there is number equal to or over 100, 
 *if the last number isn't 0, and if one of the arguments is not a integer. Then I create my necessary parameter for 
 *the recursive method and make the first recursive call. Then I print the count variable as required at the end of 
 *execution printing the number of solutions found.
 * 
 */
	public static void main(String [] args)
	{
		if (args.length < 2)
		{
			System.err.printf("Error: Incorrect usage.%n");
			System.err.printf("\t   Should be list of at least 2 values with last value equal to 0.%n");
			System.exit(1);
		}
		for(int i=0;i<args.length-1;i++) 
		{
			try 
			{
			int f= Integer.parseInt(args[i]);
			if(f<0 || f>99) 
			{
				System.err.printf("Error:the puzzle values have to be positive integers less than 100.%n");
				System.exit(1);
			}
			}
			catch(NumberFormatException e)
			{
				System.err.printf("Error: Invalid input must be integer.%n");
				System.exit(1);
			}	
			}
			if(Integer.parseInt(args[args.length-1])!=0)
			{
				System.err.printf("Error: Last value must be 0.%n");
				System.exit(1);
			}
			String[] temp= new String[args.length];
			for (int i=0;i<=args.length-1;i++) 
			{
				temp[i]=args[i];
			}
			ArrayList<String []> element= new ArrayList<>();
			exploreRecursive(args, 0, temp, element);
			if (count ==0)
				System.out.println("No way through this puzzle.");
			else		
			System.out.println("There are " + count + " ways through the puzzle.");
		
	}
	}



