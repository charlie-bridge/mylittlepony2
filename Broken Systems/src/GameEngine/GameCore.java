package GameEngine;

import java.applet.*;
import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

public class GameCore extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;

	// numbers
	public static float Scale = (720 / 720f);

	// points
	public static Point msc = new Point(0, 0);

	// Strings
	private static String name = "Curse of the Moon Anarchy";

	// JFrames
	private static JFrame frame;

	// Dimensions
	public static Dimension size = new Dimension((int) (1280 * Scale),
			(int) (720 * Scale));
	public static Dimension realSize;

	// Images
	private Image screen;

	// booleans
	private boolean isRunning;
	public static boolean isMenu;
	public static boolean isMap;
	

	// Objects
	public static Menu menu;

	public GameCore() {
		setPreferredSize(size);

		addKeyListener(new Listening());
		addMouseListener(new Listening());
		addMouseMotionListener(new Listening());
	}

	public void start() {
		requestFocus();
		// Defining objects
		menu = new Menu();
		
		//methods to run once

		// starting game loop
		isRunning = true;
		isMenu = true;
		isMap =false;
		
		new Thread(this).start();
	}

	public void stop() {

	}

	public void update() {
		if(isMenu){
			
		}
		
	}

	public void render() {
		Graphics g = screen.getGraphics();

		// rendering of objects
		if(isMenu){
		//menu.render(g);
		}
		
		// drawing screen
		g = getGraphics();
		g.drawImage(screen, 0, 0, size.width, size.height, null);
		g.dispose();
	}

	public static void main(String[] args) {
		GameCore gameCore = new GameCore();

		frame = new JFrame();
		frame.add(gameCore);
		frame.setUndecorated(true);
		frame.pack();

		realSize = new Dimension(frame.getWidth(), frame.getHeight());

		frame.setTitle(name);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		gameCore.start();

	}

	public void run() {
		screen = createVolatileImage(size.width, size.height);
		while (isRunning) {
			
			long startTime = Calendar.getInstance().getTimeInMillis();
			update();
			render();
			long endTime = Calendar.getInstance().getTimeInMillis();
			
			
			try {
				if((endTime-startTime)<1000/60.0){
				Thread.sleep((int)(1000/60.0-(endTime-startTime)));
				}
				//System.out.println(Calendar.getInstance().getTimeInMillis()-startTime);
			} catch (Exception e) {
				isRunning = false;
			}
		}
	}
}
