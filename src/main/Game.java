package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import camera.Camera;

public class Game {
	
	GameStateManager gameStateManager = new GameStateManager();
	Camera gameCamera;
	//*********** Variables *************	
	private final String GAMETITLE = "Real Time Strategy"; // Temporary title
	private int scrWidth = 1280, scrHeight = 720;
	
	//*********** START GAME ************
	public Game() {
		try {
			// Set display mode to a new display mode - taking width and height
			Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode()); // Display.setDisplayMode(new DisplayMode(scrWidth, scrHeight));
			Display.setFullscreen(true); // For now - this is false
			Display.setVSyncEnabled(true);
			Display.setTitle(GAMETITLE);
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUpOpenGL();
		gameStateManager.setGameState(2); // Set to launch game by default ----- 0 -> MENU | 1 -> PAUSE | 2 -> PLAY_GAME
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
	
	//******** SET UP OPENGL *******
	public void setUpOpenGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}
	
	//******** UPDATE GAME (GAME LOGIC GOES HERE) *********
	public void updateGame() {		
		gameStateManager.updateGame();
	}
	
	//******** DRAW GAME *********
	public void drawGame() {
		// Clear so we can draw
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		gameStateManager.drawGame();
	}

}
