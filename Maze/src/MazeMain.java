import java.applet.Applet;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MazeMain extends Applet{
	Scanner scan = new Scanner(System.in);

	public void paint(Graphics g) {
		boolean again = true;
		String question;
		
		while(again){
			
			System.out.println("Congratulations! You won!\nWould you like to play again?");
			question = scan.next();
			if(question.charAt(0) == 'n' || question.charAt(0) == 'N'){
				again = false;
				System.out.println("You may now close the application.");
			}
		}
	}

}