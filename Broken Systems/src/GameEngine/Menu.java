package GameEngine;

import java.awt.Color;
import java.awt.Graphics;

public class Menu {

	public Menu(){
		
	}
	
	
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, GameCore.size.width, GameCore.size.height);
		
	}
}
