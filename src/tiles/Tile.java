package tiles;

import java.util.Random;

import org.lwjgl.opengl.GL11;

//****** MANAGES TILES *******
public class Tile extends Tiles {

	TILE_TYPES CURRENT_TILE;
	
	//****** CREATES TILES *****
	Tiles createTile;
	
	//***** CREATE A TILE *****
	public Tile (int ID) {
		tileID = ID; // So we can select the ID to draw
		
		switch(ID) {
		case 0 :			
			CURRENT_TILE = TILE_TYPES.GRASS;
		break;
		case 1 :			
			CURRENT_TILE = TILE_TYPES.DIRT;
		break;
		}	
		
		//drawTile();
	}
	
	//***** DRAW TILE *****
	@Override
	public void drawTile(int tileX, int tileY) { // TODO: Make these have textures
		switch (CURRENT_TILE) {
		case GRASS: 
			createTile = new CreateTile(0, 255, 0); // Creates tile object
			createTile.drawTile(tileX, tileY); // Draws tile object
		break;
		case DIRT: 
			createTile = new CreateTile(0.5f, 0.35f, 0.05f);
			createTile.drawTile(tileX, tileY);
		break;
		}
	}
	
	//***** GET TILE ID (FOR USE WITH WORLD GEN) *****
	public int getTileId() {
		// TODO: get functioning...
		
		return 0;
	}

}
