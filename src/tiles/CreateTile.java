package tiles;

import org.lwjgl.opengl.GL11;

import camera.Camera;

public class CreateTile extends Tiles {
	
	public CreateTile(float r, float g, float b) {
		Red = r;
		Green = g;
		Blue = b;
	}

	@Override
	public int getTileId() {
		return tileID;
	}
	
	@Override
	public void drawTile(int tileX,  int tileY) {
		
		int tileXcoord, tileYcoord;
		tileXcoord = (tileX - tileY) * (TILE_XHALF); // TILE_WIDTH = 60
		tileYcoord = (tileX + tileY) * (TILE_YHALF); // TILE_HEIGHT = 30
		
		// set the color of the triangle (R,G,B)
		GL11.glColor3f(Red, Green, Blue);
		
		// draw triangle
		GL11.glBegin(GL11.GL_TRIANGLES);
		    GL11.glVertex2f(tileXcoord, tileYcoord);
		    GL11.glVertex2f(tileXcoord + TILE_XHALF, tileYcoord + TILE_YHALF);
		    GL11.glVertex2f(tileXcoord + (TILE_XHALF * 2), tileYcoord);
		GL11.glEnd();
		// draw triangle
		GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glVertex2f(tileXcoord, tileYcoord);
			GL11.glVertex2f(tileXcoord + TILE_XHALF, tileYcoord - TILE_YHALF);
			GL11.glVertex2f(tileXcoord + (TILE_XHALF * 2), tileYcoord);
		GL11.glEnd();
		
		gameCam.updateCamera();
	}

	

}
