package main;

import org.lwjgl.opengl.GL11;

public class LaunchGame extends GameStates{
	
	GenerateWorld worldGen;
	
	//******* LAUNCH PLAY_GAME *******
	public LaunchGame() {
		System.out.println("+++++++ GAME LAUNCHED V0.0.1 +++++++");
		worldGen = new GenerateWorld(0); // TODO: Add interface to allow use to select world size (0, 1, 2)
	}
	
	//****** LOAD CONTENT *******
	public void loadContent() {
		
	}
	
	//****** UPDATE GAME *******
	@Override 
	public void updateGame() {
		
	}
	
	//****** DRAW GAME ********
	@Override 
	public void drawGame() {
		worldGen.renderWorld();
	}

}
