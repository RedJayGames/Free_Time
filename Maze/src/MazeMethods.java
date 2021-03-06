import java.applet.Applet;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MazeMethods{
	static Random rand = new Random();
	static Scanner scan = new Scanner(System.in);

	static int x = 5,y = 5;
	static boolean win = false, wall = false, path = false;
	static int pathX[], pathY[], wallX[], wallY[];
	static final int BORDER_XL = 5, BORDER_XR = 195, BORDER_YU = 5, BORDER_YD = 195, VICTORY_X = 190, VICTORY_Y = 190;
	
	public MazeMethods () {
	}
	
	private static void GenBorders(Graphics g){
		//fills border
		g.setColor(Color.black);
		g.fillRect(0, 0, 5, 200);
		g.fillRect(0, 0, 200, 5);
		g.fillRect(195, 5, 10, 200);
		g.fillRect(5, 195, 200, 10);
	}
	
	private static void GenPath(Graphics g){
		//creates path
		g.setColor(Color.white);
		for(int i = 0, determine;!(x == VICTORY_X && y == VICTORY_Y);i++){
			determine = rand.nextInt(42);
			if(determine < 10 && x >= 10){
				x-=5;
			}else if(determine < 20 && y >= 10){
				y-=5;
			}else if(determine < 31 && x <= 185){
				x+=5;
			}else if(determine >= 31 && y<=185){
				y+=5;
			}
			g.fillRect(x, y, 5, 5);
			pathX[i] = x;
			pathY[i] = y;
		}
	}
	
	private static void GenWalls(Graphics g){
		//creates walls in random locations
		for(int wallx, wally, i = 0, count = 1000; count > 0; i++, count--, path = false){
			g.setColor(Color.black);
			wallx = (rand.nextInt(38) + 1) * 5;
			wally = (rand.nextInt(38) + 1) * 5;
			//checks if path is on the generated tile
			for(int j = 0; j < pathX.length; j++){
				if(pathX[j] == wallx && pathY[j] == wally){
					path = true;
					break;
				}
			}
			
			//creates and stores the value of the wall if the path is not there
			if(path == false) {
				g.fillRect(wallx, wally, 5, 5);
				wallX[i] = wallx;
				wallY[i] = wally;
			}
		}
	}
	
	private static void Movement(Graphics g){
		//allows player movement
		for(String input;win == false;){
			wall = false;
			//sets player location here, changes location after 
			g.setColor(Color.green);
			g.fillOval(x, y, 5, 5);
			
			//places white square on previous space after determining new location
			//prevents a trail of green circles
			g.setColor(Color.white);
			input = scan.next();
			if(input.equals("w") && y > 5){
				for(int i = 0; i < wallX.length; i++) {
					if(wallX[i] == x && wallY[i] == y - 5) {
						wall = true;
						System.out.println("Boonk!");
						break;
					}
				}
				if(wall == false){
					g.fillRect(x,y,5,5);
					y-=5;
				}
			}else if(input.equals("a") && x > 5){
				for(int i = 0; i < wallX.length; i++) {
					if(wallX[i] == x - 5 && wallY[i] == y) {
						wall = true;
						System.out.println("Boonk!");
						break;
					}
				}
				if(wall == false){
					g.fillRect(x,y,5,5);
					x-=5;
				}
			}else if(input.equals("s") && y < 190){
				for(int i = 0; i < wallX.length; i++) {
					if(wallX[i] == x && wallY[i] == y + 5) {
						wall = true;
						System.out.println("Boonk!");
						break;
					}
				}
				if(wall == false){
					g.fillRect(x,y,5,5);
					y+=5;
				}
			}else if(input.equals("d") && x < 190){
				for(int i = 0; i < wallX.length; i++) {
					if(wallX[i] == x + 5 && wallY[i] == y) {
						wall = true;
						System.out.println("Boonk!");
						break;
					}
				}
				if(wall == false){
					g.fillRect(x,y,5,5);
					x+=5;
				}
			}
			
			if(x == 190 && y == 190) {
				win = true;
			}
		}
	}
	
	public static void GameLoop(Graphics g){
		GenBorders(g);
		GenPath(g);
		GenWalls(g);
		
		//resets variables
		x = 5;
		y = 5;
		
		//ensures starting location
		g.setColor(Color.white);
		g.fillRect(5, 5, 5, 5);
		g.fillRect(5, 10, 5, 5);
		g.fillRect(10, 5, 5, 5);

		//shows exit to maze
		g.setColor(Color.magenta);
		g.fillRect(VICTORY_X, VICTORY_Y, 5, 5);
		
		Movement(g);
	}
}
