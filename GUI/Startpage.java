package GUI;
import javax.swing.JApplet;

public class Startpage extends JApplet
{
	 private final int WIDTH = 1000;
	 private final int HEIGHT = 1000;

	 public void init()
	 {
	       Controller panel = new Controller(WIDTH,HEIGHT);
	       getContentPane().add(panel);
	 }
}
