package tiles;
import org.lwjgl.opengl.GL11;

import camera.Camera;
//******* BLUEPRINT FOR ALL TILES ******
public abstract class Tiles {
	
	public final int TILE_WIDTH = 128, TILE_HEIGHT = 64;
	public final int TILE_XHALF = TILE_WIDTH / 2, TILE_YHALF = TILE_HEIGHT / 2;
	public int tileID;
	public float Red, Green, Blue;
	public Camera gameCam = new Camera();
	
	//****** ENUM LIST OF TILE TYPES *****
	public enum TILE_TYPES {
		GRASS,
		DIRT,
		WATER,
		SNOW,
	}
	
	public abstract int getTileId();	
	public abstract void drawTile(int tileX,  int tileY);

}
