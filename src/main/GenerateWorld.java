package main;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import tiles.Tile;
import tiles.Tile_Data;

public class GenerateWorld {
		
	private int[][] SMALL_MAP = new int[][] {
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
			{0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
			{0, 0, 1, 1, 1, 1, 1, 1, 0, 0 }, 
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, 
			{0, 0, 1, 1, 1, 1, 1, 1, 0, 0 },
			{0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, 
	}; // not being used currently
	
	private int[][] CURRENT_MAP;
	
	Tile tileToDraw; // TODO: Make random id generated as part of world generation
	private int currentX, currentY;
	ArrayList TILE_DATA = new ArrayList();
	
	//***** GENERATE THE WORLD ******
	public GenerateWorld(int mapSize) {
		
		switch(mapSize) {
		case 0 :
			CURRENT_MAP = SMALL_MAP; // Set map size
		break;
		}		
		Random rand = new Random();
		Tile_Data tile_Data;
		// Loop through map size and generate colors for each tile... eventually will be generating tile IDs
		for (int currentTileX = 0; currentTileX < CURRENT_MAP.length; currentTileX++) {								
			for (int currentTileY = 0; currentTileY < CURRENT_MAP.length; currentTileY++) {		
				
				int tileID = rand.nextInt(2); // 0 -> 1 are possible id's currently
				tile_Data = new Tile_Data(tileID, currentTileX, currentTileY);
				TILE_DATA.add(tile_Data); // Store the data
			}
		}		
		
	}
	
	//******** DRAW WORLD *********
	public void renderWorld() {
		for (int i = 0; i < TILE_DATA.size(); i++) {
			
			Tile_Data tempData = (Tile_Data) TILE_DATA.get(i); // Pull object out of list and use the data 
			tileToDraw = new Tile(tempData.tileID);
			tileToDraw.drawTile(tempData.tileX, tempData.tileY);
		}	
	}

}
