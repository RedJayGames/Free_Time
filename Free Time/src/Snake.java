import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class Snake extends Applet{
	public void paint(Graphics g){
		Scanner scan = new Scanner(System.in);

		int x = 0, y = 0;
		boolean win = false;

		setBackground(Color.white);

		g.setColor(Color.green);
		g.fillOval(x,y,10,10);

		for(;win == false;){
			String input = scan.next();
			if(input.charAt(0)=='w'){
				g.fillRect(x, y, 10, 10);
				y-=10;
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='a'){
				g.fillRect(x, y, 10, 10);
				x-=10;
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='s'){
				g.fillRect(x, y, 10, 10);
				y+=10;
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='d'){
				g.fillRect(x, y, 10, 10);
				x+=10;
				g.fillOval(x,y,10,10);
			}
		}
	}
}
