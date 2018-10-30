import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class GrapicsMovemet extends Applet{
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
				g.setColor(Color.black);
				g.fillRect(x, y, 10, 10);
				y-=10;
				g.setColor(Color.green);
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='a'){
				g.setColor(Color.black);
				g.fillRect(x, y, 10, 10);
				x-=10;
				g.setColor(Color.green);
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='s'){
				g.setColor(Color.black);
				g.fillRect(x, y, 10, 10);
				y+=10;
				g.setColor(Color.green);
				g.fillOval(x,y,10,10);
			}else if(input.charAt(0)=='d'){
				g.setColor(Color.black);
				g.fillRect(x, y, 10, 10);
				x+=10;
				g.setColor(Color.green);
				g.fillOval(x,y,10,10);
			}
		}
	}
}
