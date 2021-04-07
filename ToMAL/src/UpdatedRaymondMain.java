import java.util.ArrayList;
import java.util.Scanner;

public class UpdatedRaymondMain {

	public static ArrayList<Node> nodeList = new ArrayList<Node>();
	
	synchronized public static void printStatus() {
		//prints the status
		
		System.out.println("The lists of the nodes in the queue are:\n");
		
		for(Node i : nodeList ) 
		{
			// for each node in node list
			System.out.print( i.name + " : " );
			
			if( i.queue.size() == 0 ) // local queue empty
				System.out.println("The queue is empty.");
			
			else {
				for(Node j : i.queue ) {
					//print the local queue of each node
					
					System.out.print( j.name + " " );
				}
			}
			System.out.println();	
			
		}	
		
		System.out.println("The lists of the local variables are are:\n");
		for(Node i : nodeList )
		{
			if(i.localvar==null)
			{
				System.out.print( "local variable of " + i.name + " : " + i.localvar + "\n" );
			}
			else
			{
				System.out.print( "local variable of " + i.name + " : " + i.localvar.name + "\n" );
			}
			
			// for each node in node list
			//System.out.print( "local variable of " + i.name + " : " + i.localvar.name + "\n" );
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// main 
		
		Scanner sc = new Scanner(System.in);		
		
		// taking the names of each node as characters (space separated)
		System.out.println("Enter the name of nodes:-     ");
		String names = sc.nextLine();
		names = names.replace(" ","");
		
		int i, len = names.length();
		
		for( i = 0; i < len; i++ ) {
			// creating objects
			nodeList.add(new Node( names.charAt(i) ));
		}
		
		System.out.println("Enter the name of the node having the token:-  ");
		char root = sc.next().charAt(0);
		
		nodeList.get(names.indexOf(root)).setParent(null);
		
		for( Node j : nodeList ) {
			// setting their parents
			if ( j.name != root ) {
				System.out.println("Enter the parent of " + j.name + ":" );
				char parent = sc.next().charAt(0);
				j.setParent( nodeList.get( names.indexOf(parent) ) );
			}
		}
		
		printStatus();  // default status
		
		for( Node j : nodeList ) {
			// start
			if(j.parent != null) {
				j.start();
			}
		}
	}
}
