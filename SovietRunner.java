import java.util.Scanner;

/**
 * Write a description of class SovietRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SovietRunner
{
    /**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args)
	{
		Soviet lenin = new Soviet();
		
		System.out.println (lenin.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (lenin.getResponse(statement));
			statement = in.nextLine();
		}
	}
}
