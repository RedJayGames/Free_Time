import java.applet.Applet;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MazeGame extends Applet {

	public void paint(Graphics g){
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		boolean again = true;
		String question;
		
		System.out.println("Welcome to the Maze!\nYou can move using wasd, but please press \"enter\" after every input."+
				"\nRemember, you control the green dot, and your goal is to move to the magenta tile.");

		//entire game. While loop ensures quick and easy replayability with re-randomization
		while(again){
			int x = 5,y = 5;
			boolean win = false, wall = false, path = false;
			int wallsX[], wallsY[], pathX[], pathY[], wallsX1[] = null, wallsY1[] = null, pathX1[] = null, pathY1[] = null;
			wallsX = new int[1444];
			wallsY = new int[1444];
			pathX = new int[1444];
			pathY = new int[1444];


			setBackground (Color.white);

			//fills border
			g.setColor(Color.black);
			g.fillRect(0, 0, 5, 200);
			g.fillRect(0, 0, 200, 5);
			g.fillRect(195, 5, 10, 200);
			g.fillRect(5, 195, 200, 10);

			//creates path
			g.setColor(Color.white);
			for(int i = 0, determine;!(x == 190 && y == 190);i++){
				determine = rand.nextInt(14);
				if(determine < 3 && x >= 10){
					x-=5;
				}else if(determine < 6 && y >= 10){
					y-=5;
				}else if(determine < 10 && x <= 185){
					x+=5;
				}else if(determine >= 10 && y<=185){
					y+=5;
				}
				g.fillRect(x, y, 5, 5);
				pathX[i] = x;
				pathY[i] = y;

				//reduces length of array
				if(x == 190 && y == 190) {
					pathX1 = Arrays.copyOf(pathX, i);
					pathY1 = Arrays.copyOf(pathY, i);
				}
			}

			//creates walls in random locations
			for(int wallx, wally, i = 0, count = 1000; count > 0; i++, path = false){
				g.setColor(Color.black);
				wallx = (rand.nextInt(38) + 1) * 5;
				wally = (rand.nextInt(38) + 1) * 5;
				for(int j = 0; j < pathX1.length; j++){
					if(pathX1[j] == wallx && pathY1[j] == wally){
						path = true;
						break;
					}
				}
				
				if(path == false) {
					g.fillRect(wallx, wally, 5, 5);
					wallsX[i] = wallx;
					wallsY[i] = wally;
				}
				count--;

				//reduces length of array
				if(count == 0) {
					wallsX1 = Arrays.copyOf(wallsX, i);
					wallsY1 = Arrays.copyOf(wallsY, i);
				}
			}



			//reset variables
			x = 5;
			y = 5;

			//ensures starting location
			g.setColor(Color.white);
			g.fillRect(5, 5, 5, 5);
			g.fillRect(5, 10, 5, 5);
			g.fillRect(10, 5, 5, 5);

			//shows exit to maze
			g.setColor(Color.magenta);
			g.fillRect(190, 190, 5, 5);

			//allows player movement
			for(String input;win == false;){
				wall = false;
				//sets player location and changes after 
				g.setColor(Color.green);
				g.fillOval(x, y, 5, 5);
				
				//places white square on previous space after determining new location
				//prevents a trail of green circles
				g.setColor(Color.white);
				input = scan.next();
				if(input.equals("w") && y > 5){
					for(int i = 0; i < wallsX1.length; i++) {
						if(wallsX1[i] == x && wallsY1[i] == y - 5) {
							wall = true;
							break;
						}
					}
					if(wall == false){
						g.fillRect(x,y,5,5);
						y-=5;
					}
				}else if(input.equals("a") && x > 5){
					for(int i = 0; i < wallsX1.length; i++) {
						if(wallsX1[i] == x - 5 && wallsY1[i] == y) {
							wall = true;
							break;
						}
					}
					if(wall == false){
						g.fillRect(x,y,5,5);
						x-=5;
					}
				}else if(input.equals("s") && y < 190){
					for(int i = 0; i < wallsX1.length; i++) {
						if(wallsX1[i] == x && wallsY1[i] == y + 5) {
							wall = true;
							break;
						}
					}
					if(wall == false){
						g.fillRect(x,y,5,5);
						y+=5;
					}
				}else if(input.equals("d") && x < 190){
					for(int i = 0; i < wallsX1.length; i++) {
						if(wallsX1[i] == x + 5 && wallsY1[i] == y) {
							wall = true;
							break;
						}
					}
					if(wall == false){
						g.fillRect(x,y,5,5);
						x+=5;
					}
				}//else{
					//System.out.println("Boonk!");
				//}
				if(x == 190 && y == 190) {
					win = true;
				}
			}
			System.out.println("Congratulations! You won!\nWould you like to play again?");
			question = scan.next();
			if(question.charAt(0) == 'n' || question.charAt(0) == 'N'){
				again = false;
				System.out.println("You may now close the application.");
			}
		}
		scan.close();
	}
}