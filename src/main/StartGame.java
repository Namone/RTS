package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class StartGame {
	
	//*********** Variables *************
	
	private final String GAMETITLE = "Real Time Strategy"; // Temporary title
	private int scrWidth = 800, scrHeight = 600;
	
	//*********** START GAME ************
	public StartGame() {
		try {
			// Set display mode to a new display mode - taking width and height
			Display.setDisplayMode(new DisplayMode(scrWidth, scrHeight));
			Display.setFullscreen(false); // For now - this is false
			Display.setTitle(GAMETITLE);
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gameLoop(); // Keep the game running
		
	}
	
	//********** KEEP THE GAME ALIVE *********
	public void gameLoop() {
		// While we don't close the window... update it/draw it/etc.
		while (!Display.isCloseRequested()) {
			Display.update(); // Update the screen
			updateGame(); // Update game world
			drawGame();	// Draw game world
		}
	}
	
	//******** UPDATE GAME (GAME LOGIC GOES HERE) *********
	public void updateGame() {
		
	}
	
	//******** DRAW GAME *********
	public void drawGame() {
		
	}

}
